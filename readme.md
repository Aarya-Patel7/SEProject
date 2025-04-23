# Movie Rental System with Decorator Pattern

This project is a refactored version of a movie rental application that implements the Decorator Pattern to handle different pricing algorithms and frequent renter points calculations.

## Decorator Pattern Implementation

The Decorator Pattern allows you to add new behaviors to objects by placing them inside wrapper objects that contain these behaviors. This implementation includes:

1. **Base Classes**:
   - `Movie` - Abstract base class for all movies
   - `BaseMovie` - Concrete implementation of the base Movie 

2. **Decorator Classes**:
   - `MovieDecorator` - Abstract base decorator class
   - `RegularMovieDecorator` - Adds regular movie pricing
   - `ChildrenMovieDecorator` - Adds children movie pricing
   - `NewReleaseMovieDecorator` - Adds new release pricing and bonus points logic
   - `LateFeesDecorator` - Adds late fees calculation for any movie type
   - `BonusPointsDecorator` - Adds additional frequent renter points

3. **Model Classes**:
   - `Rental` - Represents a movie rental
   - `Customer` - Manages rentals and statement generation

## Benefits of the Decorator Pattern

1. **Flexibility**: Behaviors can be added to individual objects dynamically without affecting other objects
2. **Composability**: Multiple decorators can be stacked to combine behaviors
3. **Single Responsibility**: Each decorator has a single responsibility
4. **Open/Closed Principle**: The system is open for extension but closed for modification
5. **Alternative to Subclassing**: Provides a more flexible way to add functionality than inheritance alone
