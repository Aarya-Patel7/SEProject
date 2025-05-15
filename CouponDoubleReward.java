public class CouponDoubleReward extends Coupon {
    CouponDoubleReward(DiscountedTransaction t){
        super(t);
    }

    public int getRewardPoints() {
        int beforeCoupon = super.getRewardPoints();
        return beforeCoupon * 2;
    }
}
