# Movie Rental System with Strategy Pattern

This project is a refactored version of a movie rental application that implements the Strategy Pattern to handle different pricing algorithms and frequent renter points calculations.

## Strategy Pattern Implementation

The Strategy Pattern allows you to define a family of algorithms, encapsulate each one, and make them interchangeable. This implementation includes:

1. **Strategy Interfaces**:
   - `PriceStrategy` - Defines the interface for calculating rental charges
   - `FrequentRenterPointsStrategy` - Defines the interface for calculating frequent renter points

2. **Concrete Strategies**:
   - For pricing: `RegularPriceStrategy`, `ChildrenPriceStrategy`, `NewReleasePriceStrategy`
   - For points: `StandardPointsStrategy`, `NewReleasePointsStrategy`

3. **Movie Class**:
   - Uses composition instead of inheritance by having strategy objects
   - Delegates pricing and points calculations to the respective strategies

4. **MovieFactory**:
   - Provides convenience methods for creating common movie types
   - Each factory method assigns the appropriate strategies

## Benefits of the Strategy Pattern

1. **Flexibility**: Pricing and points strategies can be changed at runtime
2. **Extensibility**: New strategies can be added without modifying existing code
3. **Single Responsibility**: Each strategy class has a single responsibility
4. **Open/Closed Principle**: The system is open for extension but closed for modification
```
