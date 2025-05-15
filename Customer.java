package model;

import java.util.Enumeration;
import java.util.Vector;
import decorator.*;

/**
 * Author(s): Lalith Vennapusa and Aarya Patel
 * This program is a refactored version of the original movie-rental program with 
 * Decorator Pattern implementation for pricing and frequent renter points calculation.
 * Additional coupon system and frequent renter points redemption added.
 */

public class Customer {
    private String name;
    private double totalTransactionFees = 0;
    private int frequentTransactionPoints = 0;
    private static boolean useFreeTransaction = false;
    private boolean rentalPrint = false;
    private boolean purchasePrint = false;
    private Vector<Transaction> transactions = new Vector<Transaction>();
    
    public Customer(String name) {
        this.name = name;
    }
    
    public void addTransaction(Transaction transaction) {
        transactions.addElement(transaction);
    }
    
    public String getName() {
        return name;
    }
    
    public int getFrequentTransactionPoints() {
        return frequentTransactionPoints;
    }
    
    /**
     * Use specified number of frequent renter points
     * @param points Points to use
     */
    public void useFrequentTransactionPoints(int points) {
        if (points <= frequentTransactionPoints) {
            frequentTransactionPoints -= points;
        } else {
            throw new IllegalArgumentException("Not enough frequent renter points");
        }
    }
    
    /* Generates regular print statement stating Customer name, movie, rental price for
     * the movie, total rental fee of all movies, and number of frequent renter points
     * of the customer.
     */
    public String generateTextStatement() {
        StringBuilder customerTransactionStatement = new StringBuilder("Transaction Record for " + getName() + "\n");
        
        totalTransactionFees = 0;
        frequentTransactionPoints = 0;
        
        Enumeration<Transaction> transactionEnum = transactions.elements();
        while (transactionEnum.hasMoreElements()) {
            Transaction transaction = (Transaction) transactionEnum.nextElement();
            double transactionAmount = transaction.calculateCharge();
            frequentTransactionPoints += transaction.calculateFrequentTransactionPoints();
            
            if (transaction.getTransactionType().equals("Rental")) {
                if (!rentalPrint) {
                    customerTransactionStatement.append("    Rental Record\n");
                    rentalPrint = true;
                }

                customerTransactionStatement.append("\t").append(transaction.getMovie().getTitle())
                .append("\t").append(transactionAmount).append("\n");
            
                totalTransactionFees += transactionAmount;
            }

            if (transaction.getTransactionType().equals("Purchase")) {
                if (!purchasePrint) {
                    customerTransactionStatement.append("    Purchase Record\n");
                    purchasePrint = true;
                }
                
                customerTransactionStatement.append("\t").append(transaction.getMovie().getTitle())
                .append("\t").append(transactionAmount).append("\n");
        
                totalTransactionFees += transactionAmount;
            }

            
        }
        
        customerTransactionStatement.append("Amount owed is $").append(totalTransactionFees).append("\n");
        
        if (frequentTransactionPoints >= 10 && useFreeTransaction)
            frequentTransactionPoints -=10;
        customerTransactionStatement.append("You earned ").append(frequentTransactionPoints).append(" frequent transaction points");
        
        rentalPrint = false;
        purchasePrint = false;
        return customerTransactionStatement.toString();
    }
    
    /* Generates a statement of Customer name, movie, and rental price for
     * the movie in xml format.
     */
    public String generateXmlStatement() {
        StringBuilder xml = new StringBuilder();
        xml.append("<customer>\n");
        xml.append("  <name>").append(getName()).append("</name>\n");
           
        Enumeration<Transaction> transactionEnum = transactions.elements();
        while (transactionEnum.hasMoreElements()) {
            Transaction transaction = (Transaction) transactionEnum.nextElement();
            double transactionAmount = transaction.calculateCharge();
            int tpoints = transaction.calculateFrequentTransactionPoints();
            
            xml.append("  <rental>\n");
            xml.append("    <movie>").append(transaction.getMovie().getTitle()).append("</movie>\n");
            xml.append("    <charge>").append(transactionAmount).append("</charge>\n");
            xml.append("    <points>").append(tpoints).append("</points>\n");
            xml.append("  </rental>\n");
        }
                
        xml.append("  <total_fees>").append(totalTransactionFees).append("</total_fees>\n");
        if (frequentTransactionPoints >= 10 && useFreeTransaction)
            frequentTransactionPoints -=10;
        xml.append("  <frequent_renter_points>").append(frequentTransactionPoints).append("</frequent_renter_points>\n");
        xml.append("</customer>");
        return xml.toString();
    }
    
    // main method to test program
    public static void main(String[] args) {
        Customer customer = new Customer("John Smith");
        
        // Customer rents different types of movies with decorators

        Movie starWars = new NewReleaseMovieDecorator(new BaseMovie("Star Wars"));
        Movie independenceDay = new NewReleaseMovieDecorator(new BaseMovie("Independence Day (50% coupon)"));
        Movie findingNemo = new LateFeesDecorator(new ChildrenMovieDecorator(new BaseMovie("Finding Nemo")), 3, 1.5);
        Movie godfather = new LateFeesDecorator(new RegularMovieDecorator(new BaseMovie("The Godfather")), 2, 1.5);
        
        // Apply a 50% discount coupon to Independence Day
        Movie discountedIndependenceDay = new DiscountCouponDecorator(independenceDay, 50);
        
        // Apply a $10 off coupon for a rental worth more than $50
        Movie expensiveMovie = new LateFeesDecorator(new NewReleaseMovieDecorator(new BaseMovie("Avengers: Endgame")), 2, 5.0);
        Movie discountedExpensiveMovie = new FixedAmountDiscountDecorator(expensiveMovie, 10, 50);

        //Purchase two movies
        Movie theLionKing = new PremiumPurchaseDecorator(new PurchasePriceDecorator(new BaseMovie("The Lion King"), 20), 5);
        Movie aladdin = new PurchaseDiscountDecorator(new PurchasePriceDecorator(new BaseMovie("Aladdin"), 15), 15);
        
        customer.addTransaction(new Rental(starWars, 4));
        customer.addTransaction(new Rental(discountedIndependenceDay, 5));
        customer.addTransaction(new Rental(findingNemo, 4));
        customer.addTransaction(new Rental(godfather, 3));
        customer.addTransaction(new Rental(discountedExpensiveMovie, 10));
        customer.addTransaction(new Purchase(theLionKing));
        customer.addTransaction(new Purchase(aladdin));
        
        System.out.println("=== Text Statement ===");
        System.out.println(customer.generateTextStatement());
        
        System.out.println("\n=== XML Statement ===");
        System.out.println(customer.generateXmlStatement());
        
        // Demonstrate the free rental redemption
        FreeTransactionService freeTransactionService = new FreeTransactionService();
        
        // Add some more points to demonstrate free rental
        // customer.frequentTransactionPoints = 10; // Set to exactly 10 for demonstration
        
        System.out.println("\n=== Free Rental Eligibility ===");
        System.out.println("Current frequent renter points: " + customer.getFrequentTransactionPoints());
        System.out.println("Eligible for free rental: " + freeTransactionService.hasEnoughPointsForFreeRental(customer));
        
        // Apply free rental if eligible
        if (freeTransactionService.hasEnoughPointsForFreeRental(customer)) {
            Movie matrixMovie = new RegularMovieDecorator(new BaseMovie("The Matrix"));
            Movie freeMatrix = new FreeRentalDecorator(matrixMovie);
            useFreeTransaction = true;
            // Redeem points
            freeTransactionService.redeemPointsForFreeRental(customer);
            customer.addTransaction(new Rental(freeMatrix, 3));
            
            System.out.println("\nRedeemed points for free rental of The Matrix");
            System.out.println("Remaining points: " + customer.getFrequentTransactionPoints());
            
            System.out.println("\n=== Updated Statement After Redemption ===");
            System.out.println(customer.generateTextStatement());
        }
        
    }
}