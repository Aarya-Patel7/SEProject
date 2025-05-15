import java.util.*;

public class Transaction implements DiscountedTransaction{
    private Vector<Rental> rentals;
    private Vector<Purchase> purchases;

    public Transaction (Vector<Rental> rentals, Vector<Purchase> purchases) {
        this.rentals = rentals;
        this.purchases = purchases;
    }

    public double getAmountDue() {
        double total = 0;
        for (int i = 0; i < rentals.size(); i++) {
            Rental r = rentals.get(i);
            total += r.getPrice();
        }
        for (int i = 0; i < purchases.size(); i++) {
            Purchase p = purchases.get(i);
            total += p.getPrice();
        }
        return total;
    }

    public int getRewardPoints() {
        int total = 0;
        for (int i = 0; i < rentals.size(); i++) {
            Rental r = rentals.get(i);
            total += r.getRewardPoints();
        }
        for (int i = 0; i < purchases.size(); i++) {
            Purchase p = purchases.get(i);
            total += p.getRewardPoints();
        }
        return total;
    }
}

