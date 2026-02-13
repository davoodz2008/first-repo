/*
 * Priceable.java
 * Interface for objects with pricing - implements interfaces requirement (20 points)
 * Will be implemented by Service class
 * 
 * CIS-18A Course Project - Mobile Car Wash Service
 */

public interface Priceable {
    // Calculate total price including add-ons
    double calculateTotal();
    
    // Get base price
    double getBasePrice();
}
