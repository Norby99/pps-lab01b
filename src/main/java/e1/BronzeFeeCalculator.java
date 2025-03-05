package e1;

public class BronzeFeeCalculator implements FeeCalculator {
    private static final int DEFAULT_FEE = 1;
    private static final int SPECIAL_FEE = 0;

    private static final int FEE_BORDER = 100;

    @Override
    public int getFee(int amount) {
        if (amount < FEE_BORDER) {
            return SPECIAL_FEE;
        }
        return DEFAULT_FEE;
    }
}
