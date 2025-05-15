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

// Holds detail about Customer such as name and transactions, along with funcationality for recieving customer statement
public class Customer {
    private String name;
    // Holds a customer whole transaction history
    private Vector<DiscountedTransaction> transactions = new Vector<DiscountedTransaction>();
    int totalRentalPoints = 0;

    public Customer(String name) {
        this.name = name;
    }

    // Add a transaction to customer history
    public void addTransaction(DiscountedTransaction dt) {
        transactions.addElement(dt);
    }

    public String getName() {
        return name;
    }

    /* Generates regular print statement stating Customer name, transaction price,
     * total price of all transaction, and number of reward points
     * of the customer.
     */
    public String generateTextStatement() {
        int totalRentalPoints = 0;
        double totalLifeTimeCost = 0;

        StringBuilder customerStatement = new StringBuilder("Transaction Record for " + getName() + "\n");

        // Go through each transaction
        for (int i = 0; i < transactions.size(); i++) {
            customerStatement.append("===============\n");
            customerStatement.append(String.valueOf(i+1) + ")\n");
            DiscountedTransaction t = transactions.get(i);
            // Calculate the transactions amount and rewards
            double amountDue = t.getAmountDue();
            int rewardPoints = t.getRewardPoints();
            customerStatement.append("Amount for this transation: $" + String.valueOf(amountDue) + "\n");
            customerStatement.append("Reward points earned for this transaction: " + String.valueOf(rewardPoints) + "\n");
            totalLifeTimeCost += amountDue;
            totalRentalPoints += rewardPoints;
        } 
        // Print total for all transactions
        customerStatement.append("\n=========================\n");
        customerStatement.append("Lifetime transtions price: $" + String.valueOf(totalLifeTimeCost) + "\n");
        customerStatement.append("Total reward points in account: " + String.valueOf(totalRentalPoints) + "\n");

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
        // Create customer
        Customer customer = new Customer("John Smith");

        // Create a vector of rentals 
        Vector<Rental> rentals = new Vector<Rental>();

        // Add rentals to the vector to signify what movies are being rented by the customer for this transaction
        rentals.add(new Rental(new Movie("Jurassic Park"), new RegularPricingStratery(), new RegularFrequentRentalPoints(), 7));
        rentals.add(new Rental(new Movie("Madagascar"), new ChildrenPricingStratery(), new ChildrenFrequentRentalPoints(), 4));
        rentals.add(new Rental(new Movie("Mission Impossible"), new NewReleasePricingStratergy(), new NewReleaseFrequentRentalPoints(), 3));

        // Create a vector of purchases
        Vector<Purchase> purchases = new Vector<Purchase>();

        // Add Purchases to the vector to signify what movies are being purchased by the customer for this transaction
        purchases.add(new Purchase(new Movie("Kung Fu Panda"), new PurchaseChildrenStratergy(), new PromotedPurchasePoints()));
        purchases.add(new Purchase(new Movie("Shawshank Redemption"), new PurchaseRegularStratergy(), new RegularPurchasePoints()));
        purchases.add(new Purchase(new Movie("Se7en"), new PurchaseNewReleaseStratergy(), new PromotedPurchasePoints()));

        // customer does transactions
        // Regular transaction
        customer.addTransaction(new Transaction(rentals, purchases));
        // Transaction with 50% off coupon
        customer.addTransaction(new Coupon50Off(new Transaction(rentals, purchases)));
        // Transaction with 50% off coupon and double rewards coupon
        customer.addTransaction(new CouponDoubleReward(new Coupon50Off(new Transaction(rentals, purchases))));

        // Create a new transaction
        rentals.remove(2);
        rentals.add(new Rental(new Movie("Godzilla"), new RegularPricingStratery(), new RegularFrequentRentalPoints(), 5));
        purchases.remove(2);
        purchases.add(new Purchase(new Movie("Athadu"), new PurchaseNewReleaseStratergy(), new PromotedPurchasePoints()));

        // Regular transaction
        customer.addTransaction(new Transaction(rentals, purchases));
        // Transaction with $10 off coupon
        customer.addTransaction(new Coupon10Off(new Transaction(rentals, purchases)));

        // Print statement
        System.out.println("=== Text Statement ===");
        System.out.println(customer.generateTextStatement());

        // Print xml statement
        System.out.println("\n=== XML Statement ===");
        System.out.println(customer.generateXmlStatement());
    }
}
