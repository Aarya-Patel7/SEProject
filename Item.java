// Item represents a type of purhcase a customer can make, renting or buying
public abstract class Item {
    protected Movie movie;
    
    public Movie getMovie() {
        return movie;
    }

    // gets the price of this item
    public abstract double getPrice();

    // gets the reward you get for taking this item
    public abstract int getRewardPoints();
}
