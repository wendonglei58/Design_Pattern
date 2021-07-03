package BasicOOD.DDD.repository;

import BasicOOD.DDD.model.VirtualWalletTransactionEntity;

public class VirtualWalletTransactionRepo {

    public VirtualWalletTransactionEntity getTransactionById(long transactionId) {
        return new VirtualWalletTransactionEntity();
    }

    public void save(VirtualWalletTransactionEntity transaction) {

    }
}
