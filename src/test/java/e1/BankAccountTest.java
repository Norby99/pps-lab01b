package e1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public abstract class BankAccountTest {
    protected BankAccount account;

    protected abstract BankAccount initializeAccount();

    @BeforeEach
    void init() {
        this.account = initializeAccount();
    }

    @Test
    public void testInitiallyEmpty() {
        Assertions.assertEquals(0, this.account.getBalance());
    }

    @Test
    public void testCanDeposit() {
        this.account.deposit(1000);
        Assertions.assertEquals(1000, this.account.getBalance());
    }

    @Test
    public void testCanWithdraw() {
        this.account.deposit(1000);
        this.account.withdraw(200);
        Assertions.assertEquals(799, this.account.getBalance());
    }
}
