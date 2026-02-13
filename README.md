# Mobile Car Wash & Detailing Service
## CIS-18A Course Project - Option 1: Business Program

### Student Information
- **Name:** David Zaragoza-Quezada
- **Course:** CIS-18A Java Programming
- **Semester:** Winter 2026
- **Project Option:** Option 1 - Business Program

### Program Description
This program allows customers to book mobile car wash services by:
1. Registering their information
2. Selecting a service package ($25-$180)
3. Adding optional add-ons (+$5-$15)
4. Scheduling an appointment (Mon-Sat, 8AM-6PM)
5. Receiving an order summary saved to a text file

### Files Included
- `Person.java` - Base class for person information
- `Customer.java` - Customer class (extends Person)
- `Priceable.java` - Interface for pricing
- `Schedulable.java` - Interface for scheduling
- `Service.java` - Service class (implements Priceable)
- `Appointment.java` - Appointment class (implements Schedulable)
- `CarWashSystem.java` - Main program

### How to Compile and Run

**Option 1: Using Command Line**
```bash
javac *.java
java CarWashSystem
```

**Option 2: Using IDE (Eclipse, IntelliJ, NetBeans)**
1. Create new Java project
2. Add all .java files to src folder
3. Right-click CarWashSystem.java
4. Select "Run"

### Technical Requirements Met (200 points)

 **Comments** (15 pts) - All classes documented  
 **Data Types** (10 pts) - int, double, String, boolean  
 **Variables** (10 pts) - Proper naming and usage  
 **Switch Statements** (10 pts) - Service selection & add-ons  
 **Control Statements** (20 pts) - while, do-while, for, if-else  
 **Operators** (20 pts) - Arithmetic, logical, relational  
 **Classes** (10 pts) - 6 classes total  
 **Objects & Methods** (30 pts) - Constructors, getters, methods  
 **Arrays** (20 pts) - Service array, add-on arrays, time slots  
 **Encapsulation** (10 pts) - Private variables, public methods  
 **Inheritance** (10 pts) - Customer extends Person  
 **Import Packages** (10 pts) - java.util, java.io, java.time  
 **Interfaces** (20 pts) - Priceable and Schedulable  
 **Efficiency** (5 pts) - Clean design, input validation  

**Total: 200 points**

### Sample Output
```
========================================
  MOBILE CAR WASH & DETAILING SERVICE
========================================
Business Hours: Mon-Sat, 8AM-6PM
We come to your location!
========================================

CUSTOMER REGISTRATION
--------------------
Enter first name: John
Enter last name: Smith
Enter phone (10 digits): 9511234567
Enter service address: 123 Main St

Customer ID: CW456789

========================================
AVAILABLE SERVICES
========================================
1. Basic Wash - $25.0
   Exterior hand wash, tire cleaning, window wash
2. Standard Detail - $45.0
   Basic wash + interior vacuum, dashboard wipe
...

Select service (1-5): 2

Selected: Standard Detail

========================================
OPTIONAL ADD-ONS
========================================
1. Tire Shine        +$10
2. Air Freshener     +$5
3. Wax Protection    +$15
4. No more add-ons

Select option: 1
Added: Tire Shine
Add another? (Y/N): N

========================================
SCHEDULE APPOINTMENT
========================================
Hours: Mon-Sat, 8AM-6PM (Closed Sunday)

Enter month (1-12): 2
Enter day (1-28): 15

Date: Saturday, 2/15/2026

Time Slots:
1. Morning (8AM-12PM)
2. Afternoon (12PM-3PM)
3. Evening (3PM-6PM)
Select time (1-3): 1

Appointment confirmed!

========================================
         ORDER SUMMARY
========================================

CUSTOMER:
Name: John Smith
Phone: 9511234567
Address: 123 Main St
ID: CW456789

SERVICE:
Package: Standard Detail
Base Price: $45.0

Add-ons:
  - Tire Shine: $10.0

TOTAL: $55.0

APPOINTMENT:
ID: APT12345678
Date: Saturday, 2/15/2026
Time: 8:00 AM - 12:00 PM (Morning)

========================================

Order saved to: Order_Smith_20260212_143022.txt

Thank you for choosing our service!
```

### Testing Notes
- Program validates all input (names, phone, dates)
- Prevents Sunday bookings
- Handles invalid menu choices
- Creates timestamped output files
- All requirements tested and working

### Known Limitations
- Console-only interface (no GUI)
- No database (file-based only)
- No appointment conflict checking
- Single session (no booking history)
- Hard-coded service prices

### Author
David Zaragoza-Quezada
Moreno Valley College  
CIS-18A - Java Programming  
Winter 2026
