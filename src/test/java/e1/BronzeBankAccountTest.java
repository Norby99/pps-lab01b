package e1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BronzeBankAccountTest extends BankAccountTest {
    @Override
    protected BankAccount initializeAccount() {
        BankAccountFactory bankAccountFactory = new BankAccountFactory();
        return bankAccountFactory.createBronzeAccount();
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable() {
        this.account.deposit(1000);
        Assertions.assertThrows(IllegalStateException.class, () -> this.account.withdraw(1200));
    }

    @Test
    public void testWithoutFee() {
        this.account.deposit(1000);
        this.account.withdraw(50);
        Assertions.assertEquals(950, this.account.getBalance());
    }
}
