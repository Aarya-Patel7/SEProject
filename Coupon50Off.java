public class Coupon50Off extends Coupon {
    Coupon50Off(DiscountedTransaction t){
        super(t);
    }

    public double getAmountDue() {
        double beforeDiscount = super.getAmountDue();
        return beforeDiscount * 0.5;
    }
}