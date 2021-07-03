package BasicOOD.DDD.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;


public class VirtualWalletEntity {
    private Long walletId;

    private BigDecimal balance;

    private Long userId;

    private LocalDateTime createdTime;

    private LocalDateTime updatedTime;

    public Long getWalletId() {
        return walletId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public Long getUserId() {
        return userId;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public LocalDateTime getUpdatedTime() {
        return updatedTime;
    }
}
