/**
 * Factory for creating common movie types with appropriate strategies
 */
public class MovieFactory {
    public static Movie createRegularMovie(String title) {
        return new Movie(title, new RegularPriceStrategy(), new StandardPointsStrategy());
    }

    public static Movie createChildrenMovie(String title) {
        return new Movie(title, new ChildrenPriceStrategy(), new StandardPointsStrategy());
    }

    public static Movie createNewReleaseMovie(String title) {
        return new Movie(title, new NewReleasePriceStrategy(), new NewReleasePointsStrategy());
    }
}