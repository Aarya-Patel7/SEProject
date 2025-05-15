package model;

/**
 * Class representing a movie purchase transaction
 */
public class Purchase extends Transaction {
    
    public Purchase(Movie movie) {
        super(movie);
    }
    
    @Override
    public double calculateCharge() {
        return super.movie.getPurchasePrice();
    }
    
    @Override
    public int calculateFrequentTransactionPoints() {
        return super.movie.getPurchasePoints();
    }
    
    @Override
    public String getTransactionType() {
        return "Purchase";
    }
}