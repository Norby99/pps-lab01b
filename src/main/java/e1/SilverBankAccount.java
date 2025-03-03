package e1;

public class SilverBankAccount implements BankAccount {

    private final CoreBankAccount base;
    private final int fee;

    public SilverBankAccount(CoreBankAccount coreBankAccount) {
        this.base = coreBankAccount;
        this.fee = 1;
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
        if (this.getBalance() < amount){
            throw new IllegalStateException();
        }
        base.withdraw(amount + this.fee);
    }
}
