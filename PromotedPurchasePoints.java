// Point stratergy for movie purchases that are being promoted by the store
public class PromotedPurchasePoints extends PurchasePointStratergy {
    public int getPurchasePoints(Purchase p) {
        return (int) p.getPrice();
    }
}
