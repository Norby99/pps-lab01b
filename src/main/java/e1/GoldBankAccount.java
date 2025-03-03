package e1;

public class GoldBankAccount extends OverdraftBankAccountDecorator {
    private final static int OVERDRAFT = 500;

    public GoldBankAccount(BankAccount base) {
        super(base, OVERDRAFT);
    }
}
