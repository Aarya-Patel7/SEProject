package model;

/**
 * Class representing a movie rental
 */
public class Rental extends Transaction {
    private int daysRented;
    
    public Rental(Movie movie, int daysRented) {
        super(movie);
        this.daysRented = daysRented;
    }
    
    public int getDaysRented() {
        return daysRented;
    }
    
    public double calculateCharge() {
        return super.movie.getCharge(daysRented);
    }
    
    public int calculateFrequentTransactionPoints() {
        return super.movie.getFrequentRenterPoints(daysRented);
    }

    public String getTransactionType() {
        return "Rental";
    }

}