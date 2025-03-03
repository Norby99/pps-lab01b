package e1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SilverBankAccountTest extends BankAccountTest {
    @Override
    protected BankAccount initializeAccount() {
        return new SilverBankAccount(new CoreBankAccount());
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable() {
        this.account.deposit(1000);
        Assertions.assertThrows(IllegalStateException.class, () -> this.account.withdraw(1200));
    }
}
