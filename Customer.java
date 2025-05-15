/**
 * Author(s): Lalith Vennapusa and Aarya Patel
 * This program is a refactored version of the original movie-rental program in which
 * the following changes were made:
 * At least 3 method extraction operations
 * At least 3 new classes
 * At least 3 moving method operations
 * At least 3 renaming operations
 * 1-2 replacements of data types.
 * The main method provides a means to test the program.
 * The Strategy Design Pattern was implemented in this updated program for homework 5.
 */
import java.util.Vector;

import javax.swing.tree.TreeNode;

// Holds detail about Customer such as name and rental, along with funcationality for recieving customer statement
public class Customer {
    private String name;
    private Vector<DiscountedTransaction> transactions = new Vector<DiscountedTransaction>();
    int totalRentalPoints = 0;

    public Customer(String name) {
        this.name = name;
    }

    public void addTransaction(DiscountedTransaction dt) {
        transactions.addElement(dt);
    }
    public String getName() {
        return name;
    }

    /* Generates regular print statement stating Customer name, movie, rental price for
     * the movie, total rental fee of all movies, and number of frequent renter points
     * of the customer.
     */
    public String generateTextStatement() {
        int totalRentalPoints = 0;
        double totalLifeTimeCost = 0;

        StringBuilder customerStatement = new StringBuilder("Transaction Record for " + getName() + "\n");

        for (int i = 0; i < transactions.size(); i++) {
            customerStatement.append("===============\n");
            customerStatement.append(String.valueOf(i+1) + ")\n");
            DiscountedTransaction t = transactions.get(i);
            double amountDue = t.getAmountDue();
            int rewardPoints = t.getRewardPoints();
            customerStatement.append("Amount for this transation: $" + String.valueOf(amountDue) + "\n");
            customerStatement.append("Reward points earned for this transaction: " + String.valueOf(rewardPoints) + "\n");
            totalLifeTimeCost += amountDue;
            totalRentalPoints += rewardPoints;
        } 
        customerStatement.append("\n=========================\n");
        customerStatement.append("Lifetime transtions price: $" + String.valueOf(totalLifeTimeCost) + "\n");
        customerStatement.append("Total reward points in account: " + String.valueOf(totalRentalPoints) + "\n\n");

        this.totalRentalPoints = totalRentalPoints;

        return customerStatement.toString();
    }

    /* Generates a statement of Customer name, movie, and rental price for
     * the movie in xml format.
     */
    public String generateXmlStatement() {
        StringBuilder xml = new StringBuilder();

        xml.append("Print in xml format but because the assignment does not ask for it, implementaiton is not provided.");

        return xml.toString();
    }

    // main method to test program
    public static void main(String[] args) {
        Customer customer = new Customer("John Smith");

        Vector<Rental> rentals = new Vector<Rental>();
        rentals.add(new Rental(new Movie("Jurassic Park"), new RegularPricingStratery(), new RegularFrequentRentalPoints(), 7));
        rentals.add(new Rental(new Movie("Madagascar"), new ChildrenPricingStratery(), new ChildrenFrequentRentalPoints(), 4));
        rentals.add(new Rental(new Movie("Mission Impossible"), new NewReleasePricingStratergy(), new NewReleaseFrequentRentalPoints(), 3));


        Vector<Purchase> purchases = new Vector<Purchase>();
        purchases.add(new Purchase(new Movie("Kung Fu Panda"), new PurchaseChildrenStratergy(), new PromotedPurchasePoints()));
        purchases.add(new Purchase(new Movie("Shawshank Redemption"), new PurchaseRegularStratergy(), new RegularPurchasePoints()));
        purchases.add(new Purchase(new Movie("Se7en"), new PurchaseNewReleaseStratergy(), new PromotedPurchasePoints()));

        // customer does transactions
        customer.addTransaction(new Transaction(rentals, purchases));
        customer.addTransaction(new Coupon50Off(new Transaction(rentals, purchases)));
        customer.addTransaction(new CouponDoubleReward(new Coupon50Off(new Transaction(rentals, purchases))));

        rentals.remove(2);
        rentals.add(new Rental(new Movie("Godzilla"), new RegularPricingStratery(), new RegularFrequentRentalPoints(), 5));
        purchases.remove(2);
        purchases.add(new Purchase(new Movie("Athadu"), new PurchaseNewReleaseStratergy(), new PromotedPurchasePoints()));

        customer.addTransaction(new Transaction(rentals, purchases));
        customer.addTransaction(new Coupon10Off(new Transaction(rentals, purchases)));

        System.out.println("=== Text Statement ===");
        System.out.println(customer.generateTextStatement());

        System.out.println("\n=== XML Statement ===");
        System.out.println(customer.generateXmlStatement());
    }
}
