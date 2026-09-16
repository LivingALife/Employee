package version3;

public class Main {
    public static void main(String[] args) {

        // Create an array of Employees (polymorphic collection)
        Employee[] employees = {
                new HourlyEmployee(
                        101,
                        new MyName("Alice", "Smith"),
                        new MyDate(14, 5, 1998),
                        new MyDate(1, 6, 2022),
                        45.0f,
                        200.00
                ),
                new PieceWorkerEmployee(
                        201,
                        new MyName("Bob", "Jones"),
                        new MyDate(22, 11, 1995),
                        new MyDate(15, 3, 2021),
                        250,
                        15.00
                ),
                new CommissionEmployee(
                        301,
                        new MyName("Charlie", "Brown"),
                        new MyDate(3, 9, 1990),
                        new MyDate(10, 1, 2019),
                        75000.00
                ),
                new BasePlusCommissionEmployee(
                        401,
                        new MyName("Edward", "Santos"),
                        new MyDate(30, 7, 1988),
                        new MyDate(5, 4, 2015),
                        600000.00,
                        25000.00
                )
        };

        // Target month for birthday bonus
        int currentMonth = 9; // September

        System.out.println("--- Employee Tests ---");
        for (Employee emp : employees) {
            // Polymorphic toString() handles display
            System.out.println(emp);
            System.out.printf("Computed Salary (with bonus if birthday month): ₱%,.2f%n%n",
                    emp.computeSalary(currentMonth));
        }

        // Deep clone test
        System.out.println("--- Clone Test ---");
        Employee original = employees[0];
        Employee cloned = original.clone();

        System.out.println("Original: " + original);
        System.out.println("Cloned:   " + cloned);
        System.out.println("Are they equal? " + original.equals(cloned));
        System.out.println("Are they the same object? " + (original == cloned));
    }
}
