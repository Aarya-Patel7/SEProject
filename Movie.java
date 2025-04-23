package model;

/**
 * Abstract base class for all movies
 */
public abstract class Movie {
    private String title;
    
    public Movie(String title) {
        this.title = title;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    // Abstract methods to be implemented by concrete movies or decorators
    public abstract double getCharge(int daysRented);
    
    public int getFrequentRenterPoints(int daysRented) {
        // Default implementation returns 1 point
        return 1;
    }
}