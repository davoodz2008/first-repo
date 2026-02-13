/*
 * Person.java
 * Base class for person information
 * Demonstrates inheritance - will be extended by Customer class
 * 
 * CIS-18A Course Project - Mobile Car Wash Service
 * Option 1: Business Program
 */

public class Person {
    // Private variables - demonstrates encapsulation (10 points)
    private String firstName;
    private String lastName;
    private String phoneNumber;
    
    // Constructor for Person
    public Person(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }
    
    // Getter methods - control access to private members
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public String getFullName() {
        return firstName + " " + lastName;
    }
}
