package BasicOOD.DDD.repository;

import BasicOOD.DDD.RichBlood.VirtualWalletBO;
import BasicOOD.DDD.model.VirtualWalletEntity;

import java.math.BigDecimal;

public class VirtualWalletRepo {

    public VirtualWalletEntity getVirtualWalletEntityByUserId(long userId) {
        return new VirtualWalletEntity();
    }


    public VirtualWalletEntity getVirtualWalletEntityById(long walletId) {
        return new VirtualWalletEntity();
    }

    public void update(long walletId, BigDecimal value) {

    }

    public void save(VirtualWalletBO wallet) {

    }

}
