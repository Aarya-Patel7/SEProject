public abstract class Item {
    protected Movie movie;
    
    public Movie getMovie() {
        return movie;
    }

    public abstract double getPrice();

    public abstract int getRewardPoints();
}
