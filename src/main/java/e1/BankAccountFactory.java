package e1;

public class BankAccountFactory {
    private final int silverBankAccountFee = 1;
    private final int goldBankAccountOverdraft = 500;

    public BankAccount createSilverAccount() {
        return new FeeBankAccountDecorator(new CoreBankAccount(), this.silverBankAccountFee);
    }

    public BankAccount createGoldAccount() {
        return new OverdraftBankAccountDecorator(new CoreBankAccount(), this.goldBankAccountOverdraft);
    }

    public BankAccount createBronzeAccount() {
        return new CustomFeeBankAccountDecorator(new CoreBankAccount(), amount -> amount < 100 ? 0 : 1);
    }
}
