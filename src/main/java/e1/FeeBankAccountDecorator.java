package e1;

class FeeBankAccountDecorator implements BankAccount {
    private final BankAccount base;
    private final int fee;

    public FeeBankAccountDecorator(BankAccount baseAccount, int fee) {
        this.base = baseAccount;
        this.fee = fee;
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
        if (base.getBalance() < amount + this.fee) {
            throw new IllegalStateException("Insufficient funds for withdrawal including fee");
        }
        base.withdraw(amount + this.fee);
    }
}
