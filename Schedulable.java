/*
 * Schedulable.java
 * Interface for scheduling - second interface requirement (20 points)
 * Will be implemented by Appointment class
 * 
 * CIS-18A Course Project - Mobile Car Wash Service
 */

public interface Schedulable {
    // Check if schedule is valid
    boolean isValid();
    
    // Get formatted date
    String getDate();
}
