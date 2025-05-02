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
    private double totalRentalFees = 0;
    private int frequentRenterPoints = 0;
    private Vector<Rental> rentals = new Vector<Rental>();
    
    public Customer(String name) {
        this.name = name;
    }
    
    public void addRental(Rental rental) {
        rentals.addElement(rental);
    }
    
    public String getName() {
        return name;
    }
    
    public int getFrequentRenterPoints() {
        return frequentRenterPoints;
    }
    
    /**
     * Use specified number of frequent renter points
     * @param points Points to use
     */
    public void useFrequentRenterPoints(int points) {
        if (points <= frequentRenterPoints) {
            frequentRenterPoints -= points;
        } else {
            throw new IllegalArgumentException("Not enough frequent renter points");
        }
    }
    
    /* Generates regular print statement stating Customer name, movie, rental price for
     * the movie, total rental fee of all movies, and number of frequent renter points
     * of the customer.
     */
    public String generateTextStatement() {
        StringBuilder customerRentalStatement = new StringBuilder("Rental Record for " + getName() + "\n");
        
        totalRentalFees = 0;
        frequentRenterPoints = 0;
        
        Enumeration<Rental> rentalEnum = rentals.elements();
        while (rentalEnum.hasMoreElements()) {
            Rental rental = (Rental) rentalEnum.nextElement();
            double rentalAmount = rental.calculateCharge();
            frequentRenterPoints += rental.calculateFrequentRenterPoints();
            
            customerRentalStatement.append("\t").append(rental.getMovie().getTitle())
                  .append("\t").append(rentalAmount).append("\n");
            
            totalRentalFees += rentalAmount;
        }
        
        customerRentalStatement.append("Amount owed is $").append(totalRentalFees).append("\n");
        customerRentalStatement.append("You earned ").append(frequentRenterPoints).append(" frequent renter points");
        
        return customerRentalStatement.toString();
    }
    
    /* Generates a statement of Customer name, movie, and rental price for
     * the movie in xml format.
     */
    public String generateXmlStatement() {
        StringBuilder xml = new StringBuilder();
        xml.append("<customer>\n");
        xml.append("  <name>").append(getName()).append("</name>\n");
        
        totalRentalFees = 0;
        
        Enumeration<Rental> rentalEnum = rentals.elements();
        while (rentalEnum.hasMoreElements()) {
            Rental rental = (Rental) rentalEnum.nextElement();
            double rentalAmount = rental.calculateCharge();
            int frpoints = rental.calculateFrequentRenterPoints();
            
            totalRentalFees += rentalAmount;
            
            xml.append("  <rental>\n");
            xml.append("    <movie>").append(rental.getMovie().getTitle()).append("</movie>\n");
            xml.append("    <charge>").append(rentalAmount).append("</charge>\n");
            xml.append("    <points>").append(frpoints).append("</points>\n");
            xml.append("  </rental>\n");
        }
                
        xml.append("  <total_fees>").append(totalRentalFees).append("</total_fees>\n");
        xml.append("  <frequent_renter_points>").append(frequentRenterPoints).append("</frequent_renter_points>\n");
        xml.append("</customer>");
        return xml.toString();
    }
    
    // main method to test program
    public static void main(String[] args) {
        Customer customer = new Customer("John Smith");
        
        // Customer rents different types of movies with decorators
        Movie independenceDay = new NewReleaseMovieDecorator(new BaseMovie("Independence Day (50% coupon)"));
        Movie findingNemo = new LateFeesDecorator(new ChildrenMovieDecorator(new BaseMovie("Finding Nemo")), 3, 1.5);
        Movie godfather = new LateFeesDecorator(new RegularMovieDecorator(new BaseMovie("The Godfather")), 2, 1.5);
        
        // Apply a 50% discount coupon to Independence Day
        Movie discountedIndependenceDay = new DiscountCouponDecorator(independenceDay, 50);
        
        // Apply a $10 off coupon for a rental worth more than $50
        Movie expensiveMovie = new LateFeesDecorator(new NewReleaseMovieDecorator(new BaseMovie("Avengers: Endgame")), 2, 5.0);
        Movie discountedExpensiveMovie = new FixedAmountDiscountDecorator(expensiveMovie, 10, 50);
        
        customer.addRental(new Rental(discountedIndependenceDay, 5));
        customer.addRental(new Rental(findingNemo, 4));
        customer.addRental(new Rental(godfather, 3));
        customer.addRental(new Rental(discountedExpensiveMovie, 10));
        
        System.out.println("=== Text Statement ===");
        System.out.println(customer.generateTextStatement());
        
        System.out.println("\n=== XML Statement ===");
        System.out.println(customer.generateXmlStatement());
        
        // Demonstrate the free rental redemption
        FreeRentalService freeRentalService = new FreeRentalService();
        
        // Add some more points to demonstrate free rental
        customer.frequentRenterPoints = 10; // Set to exactly 10 for demonstration
        
        System.out.println("\n=== Free Rental Eligibility ===");
        System.out.println("Current frequent renter points (set to 10 for demonstration): " + customer.getFrequentRenterPoints());
        System.out.println("Eligible for free rental: " + freeRentalService.hasEnoughPointsForFreeRental(customer));
        
        // Apply free rental if eligible
        if (freeRentalService.hasEnoughPointsForFreeRental(customer)) {
            Movie matrixMovie = new RegularMovieDecorator(new BaseMovie("The Matrix"));
            Movie freeMatrix = new FreeRentalDecorator(matrixMovie);
            
            // Redeem points
            freeRentalService.redeemPointsForFreeRental(customer);
            customer.addRental(new Rental(freeMatrix, 3));
            
            System.out.println("\nRedeemed points for free rental of The Matrix");
            System.out.println("Remaining points: " + customer.getFrequentRenterPoints());
            
            System.out.println("\n=== Updated Statement After Redemption ===");
            System.out.println(customer.generateTextStatement());
        }
    }
}
