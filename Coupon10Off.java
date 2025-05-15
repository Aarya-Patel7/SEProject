// A type of Coupon that inherits from Coupon
public class Coupon10Off extends Coupon {
    Coupon10Off(DiscountedTransaction t) {
        super(t);
    }

    // Cuts the cost of your transaction by 10 dollars
    public double getAmountDue() {
        double beforeDiscount = super.getAmountDue();
        if (beforeDiscount < 10) {
            return 0;
        } 
        return beforeDiscount - 10;
    }

    // Adds 10 points to your reward points for the transaction
    public int getRewardPoints() {
        int beforeCoupon = super.getRewardPoints();
        return beforeCoupon + 10;
    }
}
