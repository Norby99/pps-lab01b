package e1;

public class GoldBankAccount implements BankAccount {

    private final CoreBankAccount base;
    private final int overdraft;

    public GoldBankAccount(CoreBankAccount coreBankAccount) {
        this.base = coreBankAccount;
        this.overdraft = 500;
    }

    @Override
    public int getBalance() {
        return base.getBalance();
    }

    @Override
    public void deposit(int amount) {
        base.deposit(amount);
    }

    @Override
    public void withdraw(int amount) {
        if (this.getBalance() < amount - this.overdraft){
            throw new IllegalStateException();
        }
        base.withdraw(amount);
    }
}
