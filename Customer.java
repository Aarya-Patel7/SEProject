/**
 * Author(s): Lalith Vennapusa and Aarya Patel
 * This program is a refactored version of the original movie-rental program with 
 * Strategy Design Pattern implementation for pricing and frequent renter points calculation.
 */
import java.util.Enumeration;
import java.util.Vector;

// Holds detail about Customer such as name and rental, along with functionality for receiving customer statement
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

    /* Generates regular print statement stating Customer name, movie, rental price for
     * the movie, total rental fee of all movies, and number of frequent renter points
     * of the customer.
     */
    public String generateTextStatement() {
        StringBuilder customerRentalStatement = new StringBuilder("Rental Record for " + getName() + "\n");

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

        Enumeration<Rental> rentalEnum = rentals.elements();
        while (rentalEnum.hasMoreElements()) {
            Rental rental = (Rental) rentalEnum.nextElement();
            xml.append("  <rental>\n");
            xml.append("    <movie>").append(rental.getMovie().getTitle()).append("</movie>\n");
            xml.append("    <charge>").append(rental.calculateCharge()).append("</charge>\n");
            xml.append("  </rental>\n");
        }
        xml.append("  <total fees>").append(totalRentalFees).append("</total fees>\n");
        xml.append("  <frequenter renter points>").append(frequentRenterPoints).append("</frequenter renter points>\n");
        xml.append("</customer>");
        return xml.toString();
    }

    // main method to test program
    public static void main(String[] args) {
        Customer customer = new Customer("John Smith");

        // customer rents out different types of movies
        customer.addRental(new Rental(MovieFactory.createNewReleaseMovie("Independence Day"), 5));
        customer.addRental(new Rental(MovieFactory.createChildrenMovie("Finding Nemo"), 4));
        customer.addRental(new Rental(MovieFactory.createRegularMovie("The Godfather"), 3));

        System.out.println("=== Text Statement ===");
        System.out.println(customer.generateTextStatement());

        System.out.println("\n=== XML Statement ===");
        System.out.println(customer.generateXmlStatement());
    }
}
