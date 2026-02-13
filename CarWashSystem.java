/*
 * CarWashSystem.java
 * Main program for Mobile Car Wash & Detailing Service
 * 
 * This program allows customers to:
 * - Register their information
 * - Select a car wash service package
 * - Add optional add-on services
 * - Schedule an appointment
 * - Receive an order summary displayed on console
 * 
 * CIS-18A Course Project - Option 1: Business Program
 * Demonstrates: classes, inheritance, interfaces, arrays, control statements,
 * operators, and encapsulation
 */

import java.util.Scanner;  // Import package (10 points)

public class CarWashSystem {
    
    // Scanner for user input
    private static Scanner input = new Scanner(System.in);
    
    // Main method - program entry point
    public static void main(String[] args) {
        // Display welcome message
        displayWelcome();
        
        // Get customer information
        Customer customer = getCustomerInfo();
        
        // Select service
        Service service = selectService();
        
        // Add optional add-ons
        addAddons(service);
        
        // Schedule appointment
        Appointment appointment = scheduleAppointment();
        
        // Display summary
        displaySummary(customer, service, appointment);
        
        System.out.println("\nThank you for choosing our service!");
        input.close();
    }
    
    // Display welcome message
    private static void displayWelcome() {
        System.out.println("========================================");
        System.out.println("  MOBILE CAR WASH & DETAILING SERVICE");
        System.out.println("========================================");
        System.out.println("Business Hours: Mon-Sat, 8AM-6PM");
        System.out.println("We come to your location!");
        System.out.println("========================================\n");
    }
    
    // Get customer information with validation
    // Demonstrates while loops and input validation (20 points)
    private static Customer getCustomerInfo() {
        System.out.println("CUSTOMER REGISTRATION");
        System.out.println("--------------------");
        
        String firstName = "";
        String lastName = "";
        String phone = "";
        String address = "";
        
        // Get first name with validation - while loop (20 points)
        while (firstName.isEmpty() || !isValidName(firstName)) {
            System.out.print("Enter first name: ");
            firstName = input.nextLine().trim();
            if (!isValidName(firstName)) {
                System.out.println("Error: Name should only contain letters.");
            }
        }
        
        // Get last name with validation
        while (lastName.isEmpty() || !isValidName(lastName)) {
            System.out.print("Enter last name: ");
            lastName = input.nextLine().trim();
            if (!isValidName(lastName)) {
                System.out.println("Error: Name should only contain letters.");
            }
        }
        
        // Get phone number with validation - demonstrates logical operators (20 points)
        while (phone.length() != 10 || !phone.matches("\\d+")) {
            System.out.print("Enter phone (10 digits): ");
            phone = input.nextLine().trim();
            if (phone.length() != 10) {
                System.out.println("Error: Phone must be 10 digits.");
            }
        }
        
        // Get address
        while (address.isEmpty()) {
            System.out.print("Enter service address: ");
            address = input.nextLine().trim();
        }
        
        // Create customer object (30 points)
        Customer customer = new Customer(firstName, lastName, phone, address);
        System.out.println("\nCustomer ID: " + customer.getCustomerID());
        
        return customer;
    }
    
    // Validate name (letters only)
    private static boolean isValidName(String name) {
        return name.matches("[a-zA-Z]+");
    }
    
    // Select service package
    // Demonstrates switch statement and arrays (10 points + 20 points)
    private static Service selectService() {
        // Array of services (20 points)
        Service[] services = new Service[5];
        services[0] = new Service("Basic Wash", 
            "Exterior hand wash, tire cleaning, window wash", 25.00);
        services[1] = new Service("Standard Detail", 
            "Basic wash + interior vacuum, dashboard wipe", 45.00);
        services[2] = new Service("Premium Detail", 
            "Standard detail + interior shampoo, leather care", 75.00);
        services[3] = new Service("Full Interior & Exterior", 
            "Premium detail + engine bay, headlight restore", 120.00);
        services[4] = new Service("Ultimate Showroom", 
            "Full service + clay bar, paint correction", 180.00);
        
        System.out.println("\n========================================");
        System.out.println("AVAILABLE SERVICES");
        System.out.println("========================================");
        
        // Display services using for loop (20 points)
        for (int i = 0; i < services.length; i++) {
            System.out.println((i + 1) + ". " + services[i].getName() + 
                " - $" + services[i].getBasePrice());
            System.out.println("   " + services[i].getDescription());
        }
        
        int choice = 0;
        boolean valid = false;
        
        // Get choice with switch statement (10 points)
        while (!valid) {
            System.out.print("\nSelect service (1-5): ");
            if (input.hasNextInt()) {
                choice = input.nextInt();
                input.nextLine(); // consume newline
                
                // Switch statement (10 points)
                switch (choice) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        valid = true;
                        break;
                    default:
                        System.out.println("Error: Select 1-5");
                }
            } else {
                System.out.println("Error: Enter a number");
                input.nextLine();
            }
        }
        
        Service selected = services[choice - 1];
        System.out.println("\nSelected: " + selected.getName());
        return selected;
    }
    
    // Add optional add-ons to service
    // Demonstrates do-while loop and switch (20 points + 10 points)
    private static void addAddons(Service service) {
        System.out.println("\n========================================");
        System.out.println("OPTIONAL ADD-ONS");
        System.out.println("========================================");
        
        boolean adding = true;
        
        // Do-while loop (20 points)
        do {
            System.out.println("1. Tire Shine        +$10");
            System.out.println("2. Air Freshener     +$5");
            System.out.println("3. Wax Protection    +$15");
            System.out.println("4. No more add-ons");
            
            System.out.print("\nSelect option: ");
            int choice = 0;
            if (input.hasNextInt()) {
                choice = input.nextInt();
                input.nextLine();
            } else {
                input.nextLine();
                continue;
            }
            
            // Switch statement for add-ons (10 points)
            switch (choice) {
                case 1:
                    service.addAddon("Tire Shine", 10.00);
                    System.out.println("Added: Tire Shine");
                    break;
                case 2:
                    service.addAddon("Air Freshener", 5.00);
                    System.out.println("Added: Air Freshener");
                    break;
                case 3:
                    service.addAddon("Wax Protection", 15.00);
                    System.out.println("Added: Wax Protection");
                    break;
                case 4:
                    adding = false;
                    break;
                default:
                    System.out.println("Invalid option");
            }
            
            // Ask if want more add-ons - if-else statement (20 points)
            if (adding && choice >= 1 && choice <= 3) {
                System.out.print("Add another? (Y/N): ");
                String response = input.nextLine().trim();
                if (response.equalsIgnoreCase("N")) {
                    adding = false;
                }
            }
            
        } while (adding);  // do-while loop condition
    }
    
    // Schedule appointment
    // Demonstrates control statements and operators (20 points)
    private static Appointment scheduleAppointment() {
        System.out.println("\n========================================");
        System.out.println("SCHEDULE APPOINTMENT");
        System.out.println("========================================");
        System.out.println("Hours: Mon-Sat, 8AM-6PM (Closed Sunday)");
        
        int month = 0;
        int day = 0;
        int year = 2026;
        int timeSlot = 0;
        
        // Get month - demonstrates relational operators (20 points)
        while (month < 1 || month > 12) {
            System.out.print("\nEnter month (1-12): ");
            if (input.hasNextInt()) {
                month = input.nextInt();
                input.nextLine();
                if (month < 1 || month > 12) {
                    System.out.println("Error: Month must be 1-12");
                }
            } else {
                input.nextLine();
            }
        }
        
        // Get day
        int maxDay = getDaysInMonth(month);
        while (day < 1 || day > maxDay) {
            System.out.print("Enter day (1-" + maxDay + "): ");
            if (input.hasNextInt()) {
                day = input.nextInt();
                input.nextLine();
                if (day < 1 || day > maxDay) {
                    System.out.println("Error: Invalid day");
                }
            } else {
                input.nextLine();
            }
        }
        
        // Create temporary appointment to check day
        Appointment temp = new Appointment(month, day, year, 0);
        
        // Check if Sunday - if-else statement (20 points)
        if (!temp.isValid()) {
            System.out.println("\nSorry! We are closed on Sundays.");
            System.out.println("Please restart and choose another day.");
            System.exit(0);
        }
        
        System.out.println("\nDate: " + temp.getDayOfWeek() + ", " + temp.getDate());
        
        // Select time slot
        System.out.println("\nTime Slots:");
        System.out.println("1. Morning (8AM-12PM)");
        System.out.println("2. Afternoon (12PM-3PM)");
        System.out.println("3. Evening (3PM-6PM)");
        
        while (timeSlot < 1 || timeSlot > 3) {
            System.out.print("Select time (1-3): ");
            if (input.hasNextInt()) {
                timeSlot = input.nextInt();
                input.nextLine();
            } else {
                input.nextLine();
            }
        }
        
        // Create final appointment object (30 points)
        Appointment appointment = new Appointment(month, day, year, timeSlot - 1);
        System.out.println("\nAppointment confirmed!");
        
        return appointment;
    }
    
    // Get days in month - demonstrates if-else chains (20 points)
    private static int getDaysInMonth(int month) {
        // If-else chain (20 points)
        if (month == 2) {
            return 28;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        } else {
            return 31;
        }
    }
    
    // Display order summary
    private static void displaySummary(Customer customer, Service service, 
                                       Appointment appointment) {
        System.out.println("\n========================================");
        System.out.println("         ORDER SUMMARY");
        System.out.println("========================================");
        
        // Display customer info
        System.out.println("\nCUSTOMER:");
        System.out.println("Name: " + customer.getFullName());
        System.out.println("Phone: " + customer.getPhoneNumber());
        System.out.println("Address: " + customer.getAddress());
        System.out.println("ID: " + customer.getCustomerID());
        
        // Display service info
        System.out.println("\nSERVICE:");
        System.out.println("Package: " + service.getName());
        System.out.println("Base Price: $" + service.getBasePrice());
        
        // Display add-ons if any - for loop (20 points)
        if (service.getAddonCount() > 0) {
            System.out.println("\nAdd-ons:");
            for (int i = 0; i < service.getAddonCount(); i++) {
                System.out.println("  - " + service.getAddonName(i) + 
                    ": $" + service.getAddonPrice(i));
            }
        }
        
        // Display total - calls interface method (20 points)
        System.out.println("\nTOTAL: $" + service.calculateTotal());
        
        // Display appointment
        System.out.println("\nAPPOINTMENT:");
        System.out.println("ID: " + appointment.getAppointmentID());
        System.out.println("Date: " + appointment.getDayOfWeek() + ", " + 
            appointment.getDate());
        System.out.println("Time: " + appointment.getTimeSlot());
        
        System.out.println("\n========================================");
    }
}
