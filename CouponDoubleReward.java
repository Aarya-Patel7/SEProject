// A type of Coupon that inherits from Coupon
public class CouponDoubleReward extends Coupon {
    CouponDoubleReward(DiscountedTransaction t){
        super(t);
    }

    // Gives you double the rewards points for a transaction
    public int getRewardPoints() {
        int beforeCoupon = super.getRewardPoints();
        return beforeCoupon * 2;
    }
}
