public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("John Smith");

        customer.addRental(new Rental(new Movie("Independence Day", new NewReleasePrice()), 5));
        customer.addRental(new Rental(new Movie("Finding Nemo", new ChildrenPrice()), 4));
        customer.addRental(new Rental(new Movie("The Godfather", new RegularPrice()), 3));

        System.out.println("=== Text Statement ===");
        System.out.println(customer.generateTextStatement());

        System.out.println("\n=== XML Statement ===");
        System.out.println(customer.generateXmlStatement());
    }
}
