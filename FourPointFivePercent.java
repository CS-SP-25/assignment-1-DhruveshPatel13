public class FourPointFivePercent implements SalesTaxBehavior {
    @Override
    public double compute(double amount) {
        return amount * 0.045; // 4.5% sales tax
    }
}
