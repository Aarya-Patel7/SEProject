package model;

/**
 * Abstract base class for all transaction types
 */
public abstract class Transaction {
    protected Movie movie;
    
    public Transaction(Movie movie) {
        this.movie = movie;
    }
    
    public Movie getMovie() {
        return movie;
    }
    
    /**
     * Calculate the charge for this transaction
     * @return The monetary charge
     */
    public abstract double calculateCharge();
    
    /**
     * Calculate the frequent renter/purchaser points for this transaction
     * @return The points awarded
     */
    public abstract int calculateFrequentTransactionPoints();
    
    /**
     * Gets the transaction type name
     * @return The transaction type (e.g., "Rental" or "Purchase")
     */
    public abstract String getTransactionType();
}