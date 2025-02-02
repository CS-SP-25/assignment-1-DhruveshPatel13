public class SalesTaxCalculator {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java SalesTaxCalculator <state> <amount>");
            return;
        }

        String stateName = args[0];
        double saleAmount;

        try {
            saleAmount = Double.parseDouble(args[1]);
        } catch (NumberFormatException e) {
            System.out.println("Error: Sale amount must be a valid number.");
            return;
        }

        try {
            SalesTaxBehavior taxBehavior;
            switch (stateName.toLowerCase()) {
                case "alaska":
                    taxBehavior = new NoTax();
                    break;
                case "indiana":
                    taxBehavior = new SevenPercent();
                    break;
                case "hawaii":
                    taxBehavior = new FourPointFivePercent();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid state: " + stateName);
            }

            double tax = taxBehavior.compute(saleAmount);
            System.out.printf("The sales tax on $%.2f in %s is $%.2f.%n", saleAmount, stateName, tax);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
