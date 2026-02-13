/*
 * Appointment.java
 * Appointment class implements Schedulable interface
 * Demonstrates data types, operators, and methods
 * 
 * CIS-18A Course Project - Mobile Car Wash Service
 */

import java.util.Random;

public class Appointment implements Schedulable {
    // Private variables - different data types (10 points)
    private int month;
    private int day;
    private int year;
    private int timeSlot;
    private String appointmentID;
    
    // Static array of time slot descriptions (20 points arrays)
    private static final String[] TIME_SLOTS = {
        "8:00 AM - 12:00 PM (Morning)",
        "12:00 PM - 3:00 PM (Afternoon)",
        "3:00 PM - 6:00 PM (Evening)"
    };
    
    // Constructor
    public Appointment(int month, int day, int year, int timeSlot) {
        this.month = month;
        this.day = day;
        this.year = year;
        this.timeSlot = timeSlot;
        this.appointmentID = generateID();
    }
    
    // Generate random appointment ID
    private String generateID() {
        Random rand = new Random();
        int id = 10000000 + rand.nextInt(90000000);
        return "APT" + id;
    }
    
    // Implementation of Schedulable interface
    // Check if appointment is valid (not Sunday)
    // Demonstrates operators and if-else (20 points)
    public boolean isValid() {
        String dayOfWeek = getDayOfWeek();
        
        // Logical operator - if Sunday, return false (20 points)
        if (dayOfWeek.equals("Sunday")) {
            return false;
        } else {
            return true;
        }
    }
    
    // Implementation of Schedulable interface
    public String getDate() {
        return month + "/" + day + "/" + year;
    }
    
    // Calculate day of week using Zeller's algorithm
    // Demonstrates arithmetic operators (20 points)
    public String getDayOfWeek() {
        int m = month;
        int y = year;
        
        // Adjust month for Zeller's algorithm
        if (m < 3) {
            m += 12;
            y -= 1;
        }
        
        int k = y % 100;
        int j = y / 100;
        
        // Zeller's formula - demonstrates operator precedence (20 points)
        int h = (day + ((13 * (m + 1)) / 5) + k + (k / 4) + (j / 4) - (2 * j)) % 7;
        
        String[] days = {"Saturday", "Sunday", "Monday", "Tuesday", 
                        "Wednesday", "Thursday", "Friday"};
        return days[h];
    }
    
    // Getter methods
    public String getTimeSlot() {
        return TIME_SLOTS[timeSlot];
    }
    
    public String getAppointmentID() {
        return appointmentID;
    }
}
