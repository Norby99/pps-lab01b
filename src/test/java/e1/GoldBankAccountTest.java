package e1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GoldBankAccountTest extends BankAccountTest {
    @Override
    protected BankAccount initializeAccount() {
        BankAccountFactory bankAccountFactory = new BankAccountFactory();
        return bankAccountFactory.createGoldAccount();
    }

    @Test
    @Override
    public void testCanWithdraw() {
        this.account.deposit(1000);
        this.account.withdraw(200);
        Assertions.assertEquals(800, this.account.getBalance());
    }

    @Test
    public void testCanWithdrawInNegative() {
        Assertions.assertDoesNotThrow(() -> this.account.withdraw(400));
    }

    @Test
    public void testCannotOverdraft() {
        Assertions.assertThrows(IllegalStateException.class, () -> this.account.withdraw(600));
    }
}