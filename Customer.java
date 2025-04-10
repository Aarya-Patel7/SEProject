import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String name;
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

    public String generateTextStatement() {
        StringBuilder customerRentalStatement = new StringBuilder("Rental Record for " + getName() + "\n");

        double totalRentalFees = 0;
        int frequentRenterPoints = 0;

        Enumeration<Rental> rentalEnum = rentals.elements();
        while (rentalEnum.hasMoreElements()) {
            Rental rental = (Rental) rentalEnum.nextElement();
            double rentalAmount = rental.calculateCharge();
            frequentRenterPoints += rental.calculateFrequentRenterPoints();

            customerRentalStatement.append("\t").append(rental.getMovie().getTitle())
                  .append("\t").append(rentalAmount).append("\n");

            totalRentalFees += rentalAmount;
        }

        customerRentalStatement.append("Amount owed is ").append(totalRentalFees).append("\n");
        customerRentalStatement.append("You earned ").append(frequentRenterPoints).append(" frequent renter points");

        return customerRentalStatement.toString();
    }

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

        xml.append("</customer>");
        return xml.toString();
    }
}
