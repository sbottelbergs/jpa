package credit;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Credit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Version
    private Long version;
    private BigDecimal balance;

    public Credit() {}

    public Credit(BigDecimal initialBalance) {
        this.balance = initialBalance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void changeBalance(BigDecimal delta) {
        BigDecimal newBalance = balance.add(delta);
        if (newBalance.doubleValue() >= 0.0) {
            this.balance = newBalance;
        }
    }
}
