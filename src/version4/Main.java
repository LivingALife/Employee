package version4;

public class Main {
    public static void main(String[] args) {

        String line = "======================================================================";

        // 1. Roster Initialization (capacity 6)
        EmployeeRoster roster = new EmployeeRoster(6);

        System.out.println(line);
        System.out.println("EMPLOYEE ROSTER INITIALIZATION & ENROLLMENT");
        System.out.println(line);

        // 2. Add Employees — diverse subclasses
        Employee e1 = new HourlyEmployee(101, new MyName("Alice", "M.", "Smith"),
                new MyDate(14, 9, 1998), new MyDate(1, 6, 2022), 45.0f, 200.00);
        Employee e2 = new PieceWorkerEmployee(201, new MyName("Bob", "C.", "Jones"),
                new MyDate(22, 11, 1995), new MyDate(15, 3, 2021), 250, 15.00);
        Employee e3 = new CommissionEmployee(301, new MyName("Maria", "L.", "Reyes"),
                new MyDate(3, 9, 1990), new MyDate(10, 1, 2019), 75000.00);
        Employee e4 = new BasePlusCommissionEmployee(401, new MyName("Kevin", "S.", "Tan"),
                new MyDate(30, 7, 1988), new MyDate(5, 4, 2015), 600000.00, 25000.00);
        Employee e5 = new HourlyEmployee(102, new MyName("David", "A.", "White"),
                new MyDate(12, 3, 1992), new MyDate(20, 8, 2020), 40.0f, 200.00);

        System.out.println("Added: " + e1.getEmpName().getFullName() + " (Hourly) -> " + roster.addEmployee(e1));
        System.out.println("Added: " + e2.getEmpName().getFullName() + " (Piece Worker) -> " + roster.addEmployee(e2));
        System.out.println("Added: " + e3.getEmpName().getFullName() + " (Commission) -> " + roster.addEmployee(e3));
        System.out.println("Added: " + e4.getEmpName().getFullName() + " (Base Plus Commission) -> " + roster.addEmployee(e4));
        System.out.println("Added: " + e5.getEmpName().getFullName() + " (Hourly) -> " + roster.addEmployee(e5));

        // 3. Capacity Check — roster is size 6, currently has 5, try adding a 6th and a 7th
        Employee e6 = new PieceWorkerEmployee(202, new MyName("Ella", "R.", "Cruz"),
                new MyDate(5, 1, 1997), new MyDate(1, 2, 2023), 120, 20.00);
        System.out.println("Added: " + e6.getEmpName().getFullName() + " (Piece Worker) -> " + roster.addEmployee(e6));

        Employee overflow = new HourlyEmployee(103, new MyName("Overflow", "Guy"),
                new MyDate(1, 1, 2000), new MyDate(1, 1, 2024), 40.0f, 150.00);
        boolean addedOverflow = roster.addEmployee(overflow);
        System.out.println("Attempt to add beyond capacity -> " + addedOverflow);

        // 4. Introspection Verification
        System.out.println(line);
        System.out.println("--- ROSTER COMPOSITION COUNTS ---");
        System.out.println("Hourly Employees: " + roster.countHE());
        System.out.println("Piece Worker Employees: " + roster.countPWE());
        System.out.println("Commission Employees (Pure): " + roster.countCE());
        System.out.println("Base Plus Commission Employees: " + roster.countBPCE());

        // 5. Categorical Display
        System.out.println(line);
        System.out.println("HOURLY EMPLOYEES");
        roster.displayHE();

        System.out.println(line);
        System.out.println("BASE PLUS COMMISSION EMPLOYEES");
        roster.displayBPCE();

        // 6. Polymorphic Downcast Payroll
        System.out.println(line);
        System.out.println("ROSTER PAYROLL REPORT (Target Month: Sep)");
        System.out.println(line);
        roster.displayPayroll(9);

        // 7. Removal & Array Compaction
        System.out.println(line);
        System.out.println("TESTING EMPLOYEE REMOVAL & ARRAY COMPACTION");
        System.out.println(line);
        Employee removed = roster.removeEmployee(201);
        System.out.println("Removing Employee ID 201 -> " + (removed != null ? "Successfully removed." : "Not found."));
        System.out.println("Remaining Employees in Roster:");
        roster.displayAllEmployees();
    }
}