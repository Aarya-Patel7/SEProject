import java.util.*;
// Holds one whole transaction of the customer
public class Transaction implements DiscountedTransaction{
    // Stores what they are renting by holding Rental objects
    private Vector<Rental> rentals;
    // Stores what they are purchasing by holding Purchase objects
    private Vector<Purchase> purchases;

    public Transaction (Vector<Rental> rentals, Vector<Purchase> purchases) {
        this.rentals = rentals;
        this.purchases = purchases;
    }

    // Calculate the total price from getPrice method of the whole transaction
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

    // Caluclate the total reward points that the customer gets from this transaction
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

