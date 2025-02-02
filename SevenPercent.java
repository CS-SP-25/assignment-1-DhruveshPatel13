public class SevenPercent implements SalesTaxBehavior {
    @Override
    public double compute(double amount) {
        return amount * 0.07; // 7% sales tax
    }
}
