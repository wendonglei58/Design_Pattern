package BasicOOD.DDD.Anemic;

import BasicOOD.DDD.model.InsufficientBalanceException;
import BasicOOD.DDD.model.Status;
import BasicOOD.DDD.model.VirtualWalletEntity;
import BasicOOD.DDD.model.VirtualWalletTransactionEntity;
import BasicOOD.DDD.repository.VirtualWalletRepo;
import BasicOOD.DDD.repository.VirtualWalletTransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class VirtualWalletService {
    @Autowired
    private VirtualWalletRepo walletRepo;
    @Autowired
    private VirtualWalletTransactionRepo transactionRepo;

    public VirtualWalletBO getVirtualWallet(Long walletId) {
        VirtualWalletEntity walletEntity = walletRepo.getVirtualWalletEntityById(walletId);
        VirtualWalletBO walletBO = new VirtualWalletBO(walletEntity);
        return walletBO;
    }

    public BigDecimal getBalance(Long walletId) {
        VirtualWalletBO walletBO = getVirtualWallet(walletId);
        return walletBO.getBalance();
    }

    public void credit(Long walletId, BigDecimal amount) {
        VirtualWalletEntity walletEntity = walletRepo.getVirtualWalletEntityById(walletId);
        walletRepo.update(walletId, walletEntity.getBalance().add(amount));
    }

    public void debit(Long walletId, BigDecimal amount) throws InsufficientBalanceException{
        VirtualWalletEntity walletEntity = walletRepo.getVirtualWalletEntityById(walletId);
        if (walletEntity.getBalance().compareTo(BigDecimal.ZERO) < 0) {
            throw new InsufficientBalanceException("Balance less than amount to debit");
        }
        walletRepo.update(walletId, walletEntity.getBalance().subtract(amount));
    }

    public void transfer(Long fromWalletId, Long toWalletId, BigDecimal amount) throws InsufficientBalanceException {
        VirtualWalletTransactionEntity transactionEntity = new VirtualWalletTransactionEntity();
        transactionEntity.setAmount(amount);
        transactionEntity.setFromWalletId(fromWalletId);
        transactionEntity.setToWalletId(toWalletId);
        transactionEntity.setTransactionStatus(Status.TO_BE_EXECUTED);
        transactionEntity.setCreatedTime(LocalDateTime.now());
        transactionRepo.save(transactionEntity);
        try {
            debit(fromWalletId, amount);
            credit(toWalletId, amount);

        }catch (InsufficientBalanceException ex){
            transactionEntity.setTransactionStatus(Status.CLOSED);
            transactionRepo.save(transactionEntity);
            throw ex;
        }catch (Exception ex) {
            transactionEntity.setTransactionStatus(Status.FAILED);
            transactionRepo.save(transactionEntity);
            throw ex;
        }

        transactionEntity.setTransactionStatus(Status.EXECUTED);
        transactionRepo.save(transactionEntity);
    }
}
