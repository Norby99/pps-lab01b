package e1;

class OverdraftBankAccountDecorator implements BankAccount {
    private final BankAccount base;
    private final int overdraft;

    public OverdraftBankAccountDecorator(BankAccount base, int overdraft) {
        this.base = base;
        this.overdraft = overdraft;
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
        if (base.getBalance() + this.overdraft < amount) {
            throw new IllegalStateException("Overdraft limit exceeded");
        }
        base.withdraw(amount);
    }
}
