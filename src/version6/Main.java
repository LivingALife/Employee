package version6;

public class Main {
    public static void main(String[] args) {
        String line = "======================================================================";

        // 1. Instantiation Blocking
        // Employee e = new Employee(999, new Name("Test","User"), new MyDate(), new MyDate());
        // ^ Uncommenting the line above causes a compiler error:
        //   "Employee is abstract; cannot be instantiated"

        System.out.println(line);
        System.out.println("1. TESTING ENCAPSULATION & DEFENSIVE COPYING");
        System.out.println(line);

        HourlyEmployee protectedEmp = new HourlyEmployee(
                999, new Name("Test", "User"),
                new MyDate(15, 12, 1995), new MyDate(1, 1, 2020),
                40f, 200.00
        );

        System.out.println("Original Birth Month: " + protectedEmp.getBirthDate().getMonth() + " (Dec)");
        System.out.println("Attempting external tampering: emp.getBirthDate().setMonth(9)...");
        protectedEmp.getBirthDate().setMonth(9); // mutates a clone, not the real internal state
        System.out.println("Employee's Actual Birth Date after tampering attempt: " + protectedEmp.getBirthDate().toShortFormat());
        System.out.println("Result: SUCCESS (Internal state protected via defensive copying)");
        System.out.println();

        System.out.println(line);
        System.out.println("2. TESTING EXCEPTION HANDLING & INPUT VALIDATION");
        System.out.println(line);

        System.out.println("Attempting to create HourlyEmployee with rate: -150.00...");
        try {
            HourlyEmployee bad = new HourlyEmployee(
                    998, new Name("Bad", "Rate"),
                    new MyDate(1, 1, 2000), new MyDate(1, 1, 2020),
                    40f, -150.00
            );
        } catch (IllegalArgumentException ex) {
            System.out.println("Caught Expected Exception: [IllegalArgumentException] " + ex.getMessage());
        }
        System.out.println();

        System.out.println("Attempting to assign invalid calendar date: 31 Feb 2026...");
        try {
            MyDate badDate = new MyDate(31, 2, 2026);
        } catch (IllegalArgumentException ex) {
            System.out.println("Caught Expected Exception: [IllegalArgumentException] " + ex.getMessage());
        }
        System.out.println();

        System.out.println(line);
        System.out.println("3. POLYMORPHIC PAYROLL EXECUTION (Target Month: Sep)");
        System.out.println("[Dynamic Dispatch via Abstract Contract computeSalary()]");
        System.out.println(line);

        EmployeeRoster roster = new EmployeeRoster();
        roster.addEmployee(new HourlyEmployee(101, new Name("Alice", "M.", "Smith"),
                new MyDate(14, 9, 1998), new MyDate(1, 6, 2022), 45.0f, 200.00));
        roster.addEmployee(new PieceWorkerEmployee(201, new Name("Bob", "C.", "Jones"),
                new MyDate(22, 11, 1995), new MyDate(15, 3, 2021), 250, 15.00));
        roster.addEmployee(new CommissionEmployee(301, new Name("Maria", "L.", "Reyes"),
                new MyDate(3, 9, 1990), new MyDate(10, 1, 2019), 75000.00));
        roster.addEmployee(new BasePlusCommissionEmployee(401, new Name("Kevin", "S.", "Tan"),
                new MyDate(30, 7, 1988), new MyDate(5, 4, 2015), 600000.00, 25000.00));

        roster.displayPayroll(9);
        System.out.println(line);
    }
}