package version5;

public class Main {
    public static void main(String[] args) {
        String line = "======================================================================";

        EmployeeRoster roster = new EmployeeRoster();

        System.out.println(line);
        System.out.println("DYNAMIC ROSTER INITIALIZATION (ArrayList Backend)");
        System.out.println(line);

        Employee e1 = new HourlyEmployee(101, new MyName("Alice", "M.", "Smith"),
                new MyDate(14, 9, 1998), new MyDate(1, 6, 2022), 45.0f, 200.00);
        Employee e2 = new PieceWorkerEmployee(201, new MyName("Bob", "C.", "Jones"),
                new MyDate(22, 11, 1995), new MyDate(15, 3, 2021), 250, 15.00);
        Employee e3 = new CommissionEmployee(301, new MyName("Maria", "L.", "Reyes"),
                new MyDate(3, 9, 1990), new MyDate(10, 1, 2019), 75000.00);
        Employee e4 = new BasePlusCommissionEmployee(401, new MyName("Kevin", "S.", "Tan"),
                new MyDate(30, 7, 1988), new MyDate(5, 4, 2015), 600000.00, 25000.00);

        roster.addEmployee(e1);
        System.out.println("Enrolled: " + e1.getEmpName().getFullName() + " (Hourly)");
        roster.addEmployee(e2);
        System.out.println("Enrolled: " + e2.getEmpName().getFullName() + " (Piece Worker)");
        roster.addEmployee(e3);
        System.out.println("Enrolled: " + e3.getEmpName().getFullName() + " (Commission)");
        roster.addEmployee(e4);
        System.out.println("Enrolled: " + e4.getEmpName().getFullName() + " (Base Plus Commission)");

        System.out.println("Total Roster Size: " + roster.countEmployees() + " employees");

        System.out.println();
        System.out.println(line);
        System.out.println("PURE POLYMORPHIC PAYROLL REPORT (Target Month: Sep)");
        System.out.println("[No downcasting; dynamic dispatch via Employee.computeSalary()]");
        System.out.println(line);
        roster.displayPayroll(9);

        System.out.println();
        System.out.println(line);
        System.out.println("COLLECTION REMOVAL TEST");
        System.out.println(line);
        Employee removed = roster.removeEmployee(201);
        System.out.println("Removing Employee ID 201... " + (removed != null ? "Successfully removed." : "Not found."));
        System.out.println("Updated Roster Size: " + roster.countEmployees());

        System.out.println();
        System.out.println("Current Active Employees:");
        roster.displayAllEmployees();
        System.out.println(line);
    }
}