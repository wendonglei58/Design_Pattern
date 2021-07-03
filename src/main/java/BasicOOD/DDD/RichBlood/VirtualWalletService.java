package BasicOOD.DDD.RichBlood;

import BasicOOD.DDD.model.InsufficientBalanceException;
import BasicOOD.DDD.model.Status;
import BasicOOD.DDD.model.VirtualWalletEntity;
import BasicOOD.DDD.model.VirtualWalletTransactionEntity;
import BasicOOD.DDD.repository.VirtualWalletRepo;
import BasicOOD.DDD.repository.VirtualWalletTransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * TODO
 *
 * @author Wendong Lei
 * @version 1.0
 * @since 6/9/2021
 **/
public class VirtualWalletService {
    @Autowired
    VirtualWalletRepo virtualWalletRepo;
    @Autowired
    VirtualWalletTransactionRepo transactionRepo;

    public VirtualWalletBO getVirtualWallet(Long walletId) {
        VirtualWalletEntity walletEntity = virtualWalletRepo.getVirtualWalletEntityById(walletId);
        VirtualWalletBO walletBO = new VirtualWalletBO(walletEntity);
        return walletBO;
    }

    public void credit(Long walletId, BigDecimal amount) {
        VirtualWalletBO bo = getVirtualWallet(walletId);
        bo.credit(amount);
        virtualWalletRepo.save(bo);
    }

    public void debit(Long walletId, BigDecimal amount) throws InsufficientBalanceException {
        VirtualWalletBO bo = getVirtualWallet(walletId);
        bo.debit(amount);
        virtualWalletRepo.save(bo);
    }

    public void transfer(Long fromWalletId, Long toWalletId, BigDecimal amount) {
        VirtualWalletBO  fromWallet = new VirtualWalletBO(virtualWalletRepo.getVirtualWalletEntityById(fromWalletId));
        VirtualWalletBO  toWallet = new VirtualWalletBO(virtualWalletRepo.getVirtualWalletEntityById(fromWalletId));
        VirtualWalletTransactionEntity transactionEntity = new VirtualWalletTransactionEntity();
        transactionEntity.setAmount(amount);
        transactionEntity.setFromWalletId(fromWalletId);
        transactionEntity.setToWalletId(toWalletId);
        transactionEntity.setTransactionStatus(Status.TO_BE_EXECUTED);
        transactionEntity.setCreatedTime(LocalDateTime.now());
        transactionRepo.save(transactionEntity);
        try {
            fromWallet.debit(amount);
            toWallet.credit(amount);
        }catch (InsufficientBalanceException ex) {
            transactionEntity.setTransactionStatus(Status.CLOSED);
            transactionRepo.save(transactionEntity);
        }catch (Exception ex) {
            transactionEntity.setTransactionStatus(Status.FAILED);
            transactionRepo.save(transactionEntity);
        }
        transactionEntity.setTransactionStatus(Status.EXECUTED);
        transactionRepo.save(transactionEntity);
    }
}
