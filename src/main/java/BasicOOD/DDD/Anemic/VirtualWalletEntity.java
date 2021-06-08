package BasicOOD.DDD.Anemic;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("wallet")
public class VirtualWalletEntity {
    @Id
    Long walletId;
}
