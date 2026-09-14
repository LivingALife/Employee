package version2;

public class PieceWorkerEmployee {

    private int empID;
    private MyName empName;
    private int totalPiecesFinished;
    private double ratePerPiece;
    private MyDate birthDate;
    private MyDate dateHired;

    // Default Constructor
    public PieceWorkerEmployee() {
        empID = 0;
        empName = new MyName();
        totalPiecesFinished = 0;
        ratePerPiece = 0;
        birthDate = new MyDate();
        dateHired = new MyDate();
    }

    // Partial Constructor
    public PieceWorkerEmployee(int empID, MyName empName) {
        this.empID = empID;
        this.empName = empName;
        totalPiecesFinished = 0;
        ratePerPiece = 0;
        birthDate = new MyDate();
        dateHired = new MyDate();
    }

    // Full Constructor
    public PieceWorkerEmployee(
            int empID,
            MyName empName,
            int totalPiecesFinished,
            double ratePerPiece) {

        this.empID = empID;
        this.empName = empName;
        setTotalPiecesFinished(totalPiecesFinished);
        setRatePerPiece(ratePerPiece);
        birthDate = new MyDate();
        dateHired = new MyDate();
    }

    // Getters and Setters
    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public MyName getEmpName() {
        return empName;
    }

    public void setEmpName(MyName empName) {
        this.empName = empName;
    }

    public int getTotalPiecesFinished() {
        return totalPiecesFinished;
    }

    public void setTotalPiecesFinished(int totalPiecesFinished) {
        if (totalPiecesFinished >= 0) {
            this.totalPiecesFinished = totalPiecesFinished;
        }
    }

    public double getRatePerPiece() {
        return ratePerPiece;
    }

    public void setRatePerPiece(double ratePerPiece) {
        if (ratePerPiece >= 0) {
            this.ratePerPiece = ratePerPiece;
        }
    }

    public MyDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(MyDate birthDate) {
        this.birthDate = birthDate;
    }

    public MyDate getDateHired() {
        return dateHired;
    }

    public void setDateHired(MyDate dateHired) {
        this.dateHired = dateHired;
    }

    // Compute Salary
    public double computeSalary() {

        double basePay =
                totalPiecesFinished * ratePerPiece;

        int completeHundreds =
                totalPiecesFinished / 100;

        double bonusPay =
                completeHundreds * (10 * ratePerPiece);

        return basePay + bonusPay;
    }

    // Display Employee
    public void displayPieceWorkerEmployee() {

        System.out.printf(
                "ID: %d | Name: %s | Pieces Finished: %d | "
                        + "Rate/Piece: \u20B1%.2f | Birth Date: %s | "
                        + "Date Hired: %s%n",
                empID,
                empName.getFullName(),
                totalPiecesFinished,
                ratePerPiece,
                birthDate,
                dateHired
        );
    }

    // toString
    @Override
    public String toString() {

        return String.format(
                "PieceWorkerEmployee [ID: %d, Name: %s, Pieces: %d, "
                        + "Rate: \u20B1%.2f, Birth Date: %s, Date Hired: %s, "
                        + "Total Salary: \u20B1%,.2f]",
                empID,
                empName.getFullName(),
                totalPiecesFinished,
                ratePerPiece,
                birthDate,
                dateHired,
                computeSalary()
        );
    }
}