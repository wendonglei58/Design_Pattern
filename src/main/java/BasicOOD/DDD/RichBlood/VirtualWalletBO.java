package BasicOOD.DDD.RichBlood;

import BasicOOD.DDD.model.InsufficientBalanceException;
import BasicOOD.DDD.model.VirtualWalletEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 *
 * @author Wendong Lei
 * @version 1.0
 * @since 6/9/2021
 **/
public class VirtualWalletBO {
    private Long walletId;

    private BigDecimal balance;

    private Long userId;

    private LocalDateTime createdTime;

    private LocalDateTime updatedTime;

    private BigDecimal frozenAmount = BigDecimal.ZERO;

    private boolean isAllowOverdraft;

    private BigDecimal overDraftAmount = BigDecimal.ZERO;

    public VirtualWalletBO(VirtualWalletEntity entity) {
        this.walletId = entity.getWalletId();
        this.balance = entity.getBalance();
        this.userId = entity.getUserId();
        this.createdTime = entity.getCreatedTime();
        this.updatedTime = entity.getUpdatedTime();
    }

    public VirtualWalletEntity toEntity() {
        return new VirtualWalletEntity();
        //set the value
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    public void credit(BigDecimal amount) {
        this.balance = this.balance.add(amount);
    }

    public void debit(BigDecimal amount) throws InsufficientBalanceException {
        BigDecimal availableAmount = balance.subtract(frozenAmount);
        if (availableAmount.compareTo(amount) < 0) {
            if (isAllowOverdraft) {
                BigDecimal toOverdraftAmt = amount.subtract(availableAmount);
                this.balance = this.balance.subtract(availableAmount);
                overDraft(toOverdraftAmt);
            }else {
                throw new InsufficientBalanceException("Not enough balance");
            }
        }else {
            balance = balance.subtract(amount);
        }
    }

    public void overDraft(BigDecimal amount) throws InsufficientBalanceException {
        this.overDraftAmount = amount;
    }

    public void freeze(BigDecimal amount) {
        this.frozenAmount = amount;
    }

}
