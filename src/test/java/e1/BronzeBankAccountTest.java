package e1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BronzeBankAccountTest extends BankAccountTest {
    @Override
    protected BankAccount initializeAccount() {
        return new BronzeBankAccount(new CoreBankAccount());
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable() {
        this.account.deposit(1000);
        Assertions.assertThrows(IllegalStateException.class, () -> this.account.withdraw(1200));
    }
}
