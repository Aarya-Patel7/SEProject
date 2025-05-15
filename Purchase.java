public class Purchase extends Item {
    private PurchasePricingStratergy pricingStratergy;
    private PurchasePointStratergy purchasePointStratergy;

    public Purchase (Movie movie, PurchasePricingStratergy pricingStratergy, PurchasePointStratergy purchasePointStratergy) {
        this.movie = movie;
        this.pricingStratergy = pricingStratergy;
        this.purchasePointStratergy = purchasePointStratergy;
    }

    @Override
    public double getPrice() {
        return pricingStratergy.computePurchasePrice(this);
    }

    @Override
    public int getRewardPoints() {
        return purchasePointStratergy.getPurchasePoints(this);
    }
}
