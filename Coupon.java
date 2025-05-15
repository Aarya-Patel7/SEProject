public class Coupon implements DiscountedTransaction {
    DiscountedTransaction transaction;

    public Coupon(DiscountedTransaction t) {
        this.transaction = t;
    }

    public double getAmountDue() {
        return this.transaction.getAmountDue();
    }

    public int getRewardPoints() {
        return this.transaction.getRewardPoints();
    }
}
