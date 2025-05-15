public class PurchaseChildrenStratergy extends PurchasePricingStratergy{
    public double computePurchasePrice(Purchase p) {
        return p.getMovie().getTitle().length() * 0.5 + 3;
    }
}
