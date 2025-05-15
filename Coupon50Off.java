// A type of Coupon that inherits from Coupon
public class Coupon50Off extends Coupon {
    Coupon50Off(DiscountedTransaction t){
        super(t);
    }

    // Cuts your cost for the transaction by 50%
    public double getAmountDue() {
        double beforeDiscount = super.getAmountDue();
        return beforeDiscount * 0.5;
    }
}