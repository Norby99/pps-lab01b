package e1;

public class SilverBankAccount extends FeeBankAccountDecorator {

    private final static int FEE = 1;

    public SilverBankAccount(BankAccount base) {
        super(base, FEE); // Silver ha una fee di 1
    }
}
