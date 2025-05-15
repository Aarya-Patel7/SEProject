package model;

/**
 * Service class to manage free movie rentals based on accumulated frequent renter points
 */
public class FreeTransactionService {
    private static final int POINTS_FOR_FREE_TRANSACTION = 10;
    
    /**
     * Checks if a customer has enough points for a free rental
     * @param customer The customer to check
     * @return true if the customer has enough points, false otherwise
     */
    public boolean hasEnoughPointsForFreeRental(Customer customer) {
        return customer.getFrequentTransactionPoints() >= POINTS_FOR_FREE_TRANSACTION;
    }
    
    /**
     * Redeems points for a free rental
     * @param customer The customer redeeming points
     * @return true if points were successfully redeemed, false if not enough points
     */
    public boolean redeemPointsForFreeRental(Customer customer) {
        if (hasEnoughPointsForFreeRental(customer)) {
            customer.useFrequentTransactionPoints(POINTS_FOR_FREE_TRANSACTION);
            return true;
        }
        return false;
    }
}