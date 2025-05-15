// Customer buys a movie
public class Purchase extends Item {
    // Pricing stratergy used to get the price
    private PurchasePricingStratergy pricingStratergy;
    // Reward Point stratergy to get the amount of rewards you get for buying this movie
    private PurchasePointStratergy purchasePointStratergy;

    public Purchase (Movie movie, PurchasePricingStratergy pricingStratergy, PurchasePointStratergy purchasePointStratergy) {
        this.movie = movie;
        this.pricingStratergy = pricingStratergy;
        this.purchasePointStratergy = purchasePointStratergy;
    }

    // Gets the purchase price
    @Override
    public double getPrice() {
        return pricingStratergy.computePurchasePrice(this);
    }

    // Gets the reward points for purchase
    @Override
    public int getRewardPoints() {
        return purchasePointStratergy.getPurchasePoints(this);
    }
}
