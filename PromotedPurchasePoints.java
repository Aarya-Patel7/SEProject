public class PromotedPurchasePoints extends PurchasePointStratergy {
    public int getPurchasePoints(Purchase p) {
        return (int) p.getPrice();
    }
}
