package e1;

public class BronzeBankAccount extends CustomFeeBankAccountDecorator {
    public BronzeBankAccount(BankAccount base) {
        super(base, amount -> amount < 100 ? 0 : 1); // Silver ha una fee di 1
    }
}
