public class Coupon10Off extends Coupon {
    Coupon10Off(DiscountedTransaction t) {
        super(t);
    }

    public double getAmountDue() {
        double beforeDiscount = super.getAmountDue();
        if (beforeDiscount < 10) {
            return 0;
        } 
        return beforeDiscount - 10;
    }

    public int getRewardPoints() {
        int beforeCoupon = super.getRewardPoints();
        return beforeCoupon + 10;
    }
}
