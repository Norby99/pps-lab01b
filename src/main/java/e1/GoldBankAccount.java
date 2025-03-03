package e1;

public class GoldBankAccount implements BankAccount {

    private final CoreBankAccount base;

    public GoldBankAccount(CoreBankAccount coreBankAccount) {
        this.base = coreBankAccount;
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
        if (this.getBalance() < amount - 500){
            throw new IllegalStateException();
        }
        base.withdraw(amount);
    }
}
