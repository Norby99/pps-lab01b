package e1;

class CustomFeeBankAccountDecorator implements BankAccount {
    private final BankAccount base;
    private final FeeCalculator feeCalculator;

    public CustomFeeBankAccountDecorator(BankAccount baseAccount, FeeCalculator feeCalculator) {
        this.base = baseAccount;
        this.feeCalculator = feeCalculator;
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
        int fee = feeCalculator.getFee(amount);
        if (base.getBalance() < amount + fee) {
            throw new IllegalStateException("Insufficient funds for withdrawal including fee");
        }
        base.withdraw(amount + fee);
    }
}
