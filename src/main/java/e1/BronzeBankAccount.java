package e1;

public class BronzeBankAccount extends FeeBankAccountDecorator {

    private final static int FEE = 1;

    public BronzeBankAccount(BankAccount base) {
        super(base, FEE); // Silver ha una fee di 1
    }
}
