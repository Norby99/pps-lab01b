package e1;

import java.util.function.Function;

class CustomFeeBankAccountDecorator implements BankAccount {
    private final BankAccount base;
    private final Function<Integer, Integer> feeCalculator;

    public CustomFeeBankAccountDecorator(BankAccount baseAccount, Function<Integer, Integer> feeCalculator) {
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
        int fee = feeCalculator.apply(amount);
        if (base.getBalance() < amount + fee) {
            throw new IllegalStateException("Insufficient funds for withdrawal including fee");
        }
        base.withdraw(amount + fee);
    }
}
