# step_semester_3
## Date: 29-08-2026
**Today's Work:**
- Created package structure for 'String' topic.
- Solved Prime Checker, GCD Calculator, Palindrome Checker, Star Pattern, and Armstrong Checker in `class_problems`.
- Solved ATM Pin Retry, Guess The Number, Multiplication Table, Number Pyramid, and Traffic Signal Simulator in `assignment_problems`.

**Next Session Plan:**
- Start working on Array manipulation problems.

**Issues Faced:**
- None.
---

## Date: 05-09-2026
**Today's Work:**
- Completed Day 2 Live-Coding Session (5 Problems) focusing on String manipulation:
  - Implemented Vowel & Consonant Counter using `charAt()` and case-insensitive comparison.
  - Created CSV Student Record Parser using `split(",")` and array length validation.
  - Built File Extension Validator using `lastIndexOf(".")` and `substring()`.
  - Developed Masked Phone Number Formatter using `StringBuilder` and `insert()`.
  - Designed Bank Transaction Reference Generator with multi-stage validation (`trim()`, `isLetter()`, `isDigit()`).

- Completed Week 2 Assignment (5 Problems) focusing on advanced String handling:
  - Implemented ATM PIN Length Validator using basic `length()` checks.
  - Created Word Reversal Encoder using `split(" ")` and `StringBuilder.reverse()`.
  - Built Product Inventory CSV Parser with formatted output.
  - Developed Library ISBN Normalizer & Validator with complex character-type checks.
  - Implemented Stop-Word-Filtered Word Frequency Report (conceptual understanding).

**Next Session Plan:**
- Start working on Array manipulation problems (e.g., Finding max/min, reversing arrays, searching).

**Issues Faced:**
- None. (Or mention if you struggled with `StringBuilder` syntax or `split()` edge cases).
---

## Date: 12-09-2026
**Today's Work:**
- Completed Session 4: Advanced Array Problems.
- Solved Two Sum, Best Time to Buy/Sell Stock, Contains Duplicate, Merge Sorted Arrays, Rotate Array in class_problems.
- Solved Find Min in Rotated Array, Max Subarray, Product Except Self, Subarray Sum Equals K, Three Sum in assignment_problems.
- Organized code under 'advanced_arrays' package with class_problems and assignment_problems sub-packages.

**Next Session Plan:**
- Start working on OOPS concepts.

**Issues Faced:**
- None. (Or mention if you had any)
---

## Date: 12-09-2026
**Today's Work:**
- Completed Week 5 Category C Practice Problems (5 Problems) focusing on Array manipulation and method logic:
  - Implemented `curveScores()` to modify an array in-place using pass-by-reference logic.
  - Created `findDuplicateTeam()` using nested loops to detect duplicate strings without Collections.
  - Developed `findTopThreeScores()` to track top 3 values in a single pass without sorting.
  - Built `classifyRows()` with a helper `rowAverage()` method to analyze 2D jagged arrays.
  - Designed `shortlistAndRank()` using Method Overloading, Encapsulation, and `Comparable` interface for custom object sorting.

- Completed Week 5 Assignment Problems (5 Problems) focusing on advanced array handling:
  - Implemented `applyMultipliers()` to modify specific indices in a double array directly.
  - Created `findDuplicatePick()` to check for repeated player names using pairwise comparison.
  - Developed `findMinMaxSpread()` to calculate min, max, and spread in a single traversal.
  - Built `classifyMatches()` with a reusable `rowAverage()` helper for 2D grid analysis.
  - Designed `draftAndRank()` using overloaded eligibility checks and `Comparable` for auto-draft ranking.

**Next Session Plan:**
- Start working on classes and objects problems.

**Issues Faced:**
- None. (Or mention if you struggled with `Comparable` interface or 2D array indexing).
---

## Date: 14-09-2026
**Today's Work:**
- Completed Week 6 Category C Practice Problems (5 Problems) focusing on OOP fundamentals:
  - Implemented `PlacementRecord` class with constructor and instance method `printRecord()` to manage student placement data.
  - Created `MessWallet` class demonstrating encapsulation with private fields, validation in constructor, and controlled `topUp()`/`deduct()` methods.
  - Developed `Course` class using constructor chaining (`this(...)`) to handle both theory-only and lab-included courses.
  - Built `IdCard` class to demonstrate object reference behavior, showing how multiple variables can point to the same object vs. separate instances.
  - Designed `Student` class utilizing static fields (`collegeName`, `studentCount`) and a static method `printCollegeInfo()` to share data across all objects.

- Completed Week 6 Assignment Problems (5 Problems) focusing on advanced OOP design:
  - Implemented `BookInventory` class to replace parallel arrays with an object-oriented approach for library management.
  - Created `PayrollAccount` class with strict encapsulation, ensuring net salary cannot be set directly and bonuses/taxes are validated.
  - Developed `Employee` class using constructor overloading and chaining to differentiate between permanent employees and interns.
  - Built `HallTicket` class to reinforce concepts of object references and memory identity (`==` operator).
  - Designed `CompanyEmployee` system using static members to track global company info and employee count efficiently.

**Next Session Plan:**
- Start working on Inheritance and Polymorphism (Method Overriding, Super keyword, Abstract classes).

**Issues Faced:**
- None. (Or mention if you struggled with constructor chaining or static vs. instance context).
---

## Date: 20-09-2026
**Today's Work:**
- Completed Week 7 Category C Practice Problems (5 Problems) focusing on Encapsulation fundamentals:
  - Implemented `PiggyBank` class with private savings, final ID, and controlled `deposit()`/`withdraw()` methods to prevent direct state modification.
  - Created `Scorecard` class that stores answer results in a private array, exposing only the total score via `getScore()` while hiding raw data.
  - Developed `NameTag` class as an immutable object, splitting full names in the constructor and providing a read-only `getNickname()` method.
  - Built `Locker` class with a write-only combination code, requiring the current code for validation before allowing changes via `changeCode()`.
  - Designed `AttendanceSheet` class that tracks present students internally but only reveals counts and existence checks (`isPresent()`) without exposing the full list.

- Completed Week 7 Assignment Problems (5 Problems) focusing on advanced access control and data integrity:
  - Implemented `Character` health system with clamping logic in `takeDamage()` and `heal()` to ensure health stays within [0, maxHealth] bounds.
  - Created `Playlist` class that returns a safe copy of its song array via `getSongs()`, preventing external modifications from affecting internal state.
  - Developed `PasswordChecker` class that evaluates strength ("Weak"/"Medium"/"Strong") based on length/rules without ever exposing the actual password string.
  - Built `TrafficLight` class where color transitions are strictly controlled by a `next()` method (Red→Green→Yellow→Red), preventing arbitrary state jumps.
  - Designed `Cart` class that computes total price and item count on-the-fly from a private price array, ensuring no direct access to individual item prices.

**Next Session Plan:**
- Start working on Inheritance and Polymorphism (Method Overriding, Super keyword, Abstract classes).

**Issues Faced:**
- None. (Or mention if you struggled with returning safe copies of arrays or implementing write-only fields).
---

## Date: 10-10-2026
**Today's Work:**
- Completed Week 8 Category C Practice Problems (5 Problems) focusing on Polymorphism and Dynamic Dispatch:
  - Implemented `PaymentSystem` using polymorphic classes (`Card`, `Wallet`, `BankTransfer`) to calculate transaction fees without type-checking.
  - Created `LibraryItem` hierarchy (`Book`, `DVD`, `Magazine`) to calculate due dates based on specific borrowing periods via method overriding.
  - Developed `DeliveryFee` system (`Standard`, `Express`, `International`) where each class encapsulates its own pricing logic.
  - Built `QuestionGrader` system (`MCQ`, `TF`, `Essay`) that evaluates answers polymorphically, handling partial credit for essays internally.
  - Designed `TransportFare` calculator (`Bus`, `Train`, `Metro`) applying distinct fare rules and peak-hour multipliers dynamically.

- Completed Week 8 Coding Assignment (5 Problems) focusing on real-world polymorphic design patterns:
  - Implemented `CanteenBilling` system where `Student`, `Staff`, and `Guest` objects calculate final bills with discounts/charges via overridden methods.
  - Created `ParkingCharge` calculator for `Bike`, `Car`, and `Truck` types, handling hourly rates and minimum charges polymorphically.
  - Developed `HostelElectricityBill` system for `Single`, `Shared`, and `AC` rooms, ensuring shared costs are split correctly within the object.
  - Built `FestivalBonus` calculator where `FullTime`, `PartTime`, and `Intern` employees compute bonuses based on their specific employment rules.
  - Designed `StreamingRenewal` system using `LocalDate` to calculate renewal dates for `Basic`, `Standard`, and `Premium` plans without conditional logic in the main loop.

**Next Session Plan:**
- Start working on Interfaces, Exception Handling, and File I/O operations.

**Issues Faced:**
- None. (Or mention if you struggled with designing the base abstract class vs. interface).
---

## Date: 17-09-2026
**Today's Work:**
- Completed Session 9 Category C Practice Problems (5 Problems) focusing on Abstraction and Interfaces:
  - Implemented `GardenPlot` system using an abstract base class to calculate areas for Circle, Rectangle, and Triangle without type-checking.
  - Created `StaffPay` system where `FullTime`, `Hourly`, and `Intern` subclasses override `calculatePay()` to handle distinct salary rules (including overtime logic).
  - Developed `LibraryFine` calculator where `Book`, `DVD`, and `Magazine` classes implement specific fine caps and rates via method overriding.
  - Built `ElectricityBill` system using abstraction to model Home, Shop, and Factory billing slabs with minimum charge constraints.
  - Designed `TravelBooking` system where an abstract base class handles the common booking fee, while subclasses (`Bus`, `Train`, `Flight`) implement unique fare logic.

- Completed Session 9 Coding Assignment (5 Problems) focusing on Interface-based design and mixed inheritance:
  - Implemented `MovieTicket` counter where a shared convenience fee is handled in the base class, while seat types (`Regular`, `Premium`, `Recliner`) define base prices.
  - Created `ParcelShipping` desk using interfaces to separate "shippable" behavior from "insurable" behavior, allowing only Express/Fragile parcels to carry insurance.
  - Developed `CollegeFee` counter where transport fees are applied polymorphically based on whether a student type implements a `TransportUser` interface.
  - Built `CityCab` fare meter where night service availability is controlled via an interface, rejecting night trips for Mini cabs while applying surcharges for Sedan/SUV.
  - Designed `ApplianceEnergy` report where saver mode support is defined by an interface, ensuring Fridge/TV reject saver requests while AC/Washer apply discounts.

**Next Session Plan:**
- Start working on Exception Handling (Try-Catch, Custom Exceptions, Finally block) and File I/O basics.

**Issues Faced:**
- None. (Or mention if you struggled with deciding when to use an Abstract Class vs. an Interface for shared behavior).
---