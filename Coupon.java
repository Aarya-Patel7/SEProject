// Coupon is the super class that all the couppons will be extended from
public class Coupon implements DiscountedTransaction {
    // Stores a reference to another DiscountedTransation to act as decorator
    DiscountedTransaction transaction;

    // Takes in a DiscountedTransaction
    public Coupon(DiscountedTransaction t) {
        this.transaction = t;
    }

    // Calculates amount due from the DiscountedTransaction we hold a refernce to
    public double getAmountDue() {
        return this.transaction.getAmountDue();
    }

    // Calculates reward points from the DiscountedTransaction we hold a refernce to
    public int getRewardPoints() {
        return this.transaction.getRewardPoints();
    }
}
