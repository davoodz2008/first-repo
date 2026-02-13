/*
 * Customer.java
 * Customer class extends Person - demonstrates inheritance (10 points)
 * 
 * CIS-18A Course Project - Mobile Car Wash Service
 */

import java.util.Random;

public class Customer extends Person {
    // Private variables specific to Customer
    private String address;
    private String customerID;
    
    // Constructor - calls parent constructor with super()
    public Customer(String firstName, String lastName, String phoneNumber, String address) {
        super(firstName, lastName, phoneNumber); // Call parent constructor
        this.address = address;
        this.customerID = generateID();
    }
    
    // Generate random customer ID
    private String generateID() {
        Random rand = new Random();
        int id = 100000 + rand.nextInt(900000);
        return "CW" + id;
    }
    
    // Getter methods
    public String getAddress() {
        return address;
    }
    
    public String getCustomerID() {
        return customerID;
    }
}
