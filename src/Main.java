import version1.*;

public class Main {

    public static void main(String[] args) {

        // =====================================================
        // HOURLY EMPLOYEE TEST
        // =====================================================

        // First instance: Default constructor + setters
        HourlyEmployee hourly1 = new HourlyEmployee();

        hourly1.setEmpID(101);
        hourly1.setEmpName("Alice Smith");
        hourly1.setTotalHoursWorked(45.0f);
        hourly1.setRatePerHour(200.00);

        // Second instance: Full constructor
        HourlyEmployee hourly2 =
                new HourlyEmployee(102, "John Doe", 38.0f, 180.00);

        System.out.println("--- Hourly Employee Test ---");
        System.out.println("[displayHourlyEmployee()]");
        hourly1.displayHourlyEmployee();

        System.out.println();
        System.out.println("[toString()]");
        System.out.println(hourly1);

        // =====================================================
        // PIECE WORKER EMPLOYEE TEST
        // =====================================================

        PieceWorkerEmployee piece1 = new PieceWorkerEmployee();

        piece1.setEmpID(201);
        piece1.setEmpName("Bob Jones");
        piece1.setTotalPiecesFinished(250);
        piece1.setRatePerPiece(15.00);

        PieceWorkerEmployee piece2 =
                new PieceWorkerEmployee(202, "Jane Doe", 350, 12.00);

        System.out.println();
        System.out.println("--- Piece Worker Employee Test ---");
        System.out.println("[displayPieceWorkerEmployee()]");
        piece1.displayPieceWorkerEmployee();

        System.out.println();
        System.out.println("[toString()]");
        System.out.println(piece1);

        // =====================================================
        // COMMISSION EMPLOYEE TEST
        // =====================================================

        CommissionEmployee commission1 = new CommissionEmployee();

        commission1.setEmpID(301);
        commission1.setEmpName("Charlie Brown");
        commission1.setTotalSale(75000.00);

        CommissionEmployee commission2 =
                new CommissionEmployee(302, "Diana Reyes", 150000.00);

        System.out.println();
        System.out.println("--- Commission Employee Test ---");
        System.out.println("[displayCommissionEmployee()]");
        commission1.displayCommissionEmployee();
        commission2.displayCommissionEmployee();

        System.out.println();
        System.out.println("[toString()]");
        System.out.println(commission1);
        System.out.println(commission2);

        // =====================================================
        // BASE PLUS COMMISSION EMPLOYEE TEST
        // =====================================================

        BasePlusCommissionEmployee basePlus1 =
                new BasePlusCommissionEmployee();

        basePlus1.setEmpID(401);
        basePlus1.setEmpName("Edward Santos");
        basePlus1.setTotalSale(600000.00);
        basePlus1.setBaseSalary(25000.00);

        BasePlusCommissionEmployee basePlus2 =
                new BasePlusCommissionEmployee(
                        402,
                        "Fiona Garcia",
                        90000.00,
                        30000.00
                );

        System.out.println();
        System.out.println("--- Base Plus Commission Employee Test ---");
        System.out.println("[displayBasePlusCommissionEmployee()]");
        basePlus1.displayBasePlusCommissionEmployee();
        basePlus2.displayBasePlusCommissionEmployee();

        System.out.println();
        System.out.println("[toString()]");
        System.out.println(basePlus1);
        System.out.println(basePlus2);
    }
}