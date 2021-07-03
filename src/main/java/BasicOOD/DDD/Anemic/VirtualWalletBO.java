package BasicOOD.DDD.Anemic;

import BasicOOD.DDD.model.VirtualWalletEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class VirtualWalletBO {

    private Long walletId;

    private BigDecimal balance;

    private Long userId;

    private LocalDateTime createdTime;

    private LocalDateTime updatedTime;

    public VirtualWalletBO(VirtualWalletEntity entity) {
        this.walletId = entity.getWalletId();
        this.balance = entity.getBalance();
        this.userId = entity.getUserId();
        this.createdTime = entity.getCreatedTime();
        this.updatedTime = entity.getUpdatedTime();
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
