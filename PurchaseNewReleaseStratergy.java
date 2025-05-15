// Stratergy for pricing new release movie purchases
public class PurchaseNewReleaseStratergy extends PurchasePricingStratergy {
    public double computePurchasePrice(Purchase p) {
        return p.getMovie().getTitle().length() * 2;
    }
} 