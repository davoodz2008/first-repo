/*
 * Service.java
 * Service class implements Priceable interface
 * Demonstrates arrays, operators, and methods (30 points)
 * 
 * CIS-18A Course Project - Mobile Car Wash Service
 */

public class Service implements Priceable {
    // Private variables
    private String name;
    private String description;
    private double basePrice;
    private String[] addOns;        // Array of add-on names (20 points)
    private double[] addonPrices;   // Array of add-on prices
    private int addonCount;         // Track number of add-ons
    
    // Constructor
    public Service(String name, String description, double basePrice) {
        this.name = name;
        this.description = description;
        this.basePrice = basePrice;
        this.addOns = new String[10];      // Max 10 add-ons
        this.addonPrices = new double[10];
        this.addonCount = 0;
    }
    
    // Add an add-on service
    public void addAddon(String addonName, double price) {
        if (addonCount < 10) {  // if statement (20 points)
            addOns[addonCount] = addonName;
            addonPrices[addonCount] = price;
            addonCount++;
        }
    }
    
    // Implementation of Priceable interface
    // Calculate total price using operators (20 points)
    public double calculateTotal() {
        double total = basePrice;  // double data type (10 points)
        
        // for loop to sum add-ons (20 points)
        for (int i = 0; i < addonCount; i++) {
            total += addonPrices[i];  // += operator
        }
        
        return total;
    }
    
    // Implementation of Priceable interface
    public double getBasePrice() {
        return basePrice;
    }
    
    // Getter methods
    public String getName() {
        return name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public int getAddonCount() {
        return addonCount;
    }
    
    public String getAddonName(int index) {
        return addOns[index];
    }
    
    public double getAddonPrice(int index) {
        return addonPrices[index];
    }
}
