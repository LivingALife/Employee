package version3;

import java.util.Objects;

public class PieceWorkerEmployee extends Employee {

    private int totalPiecesFinished;
    private double ratePerPiece;

    // Default constructor
    public PieceWorkerEmployee() {
        super();
        totalPiecesFinished = 0;
        ratePerPiece = 0;
    }

    // Partial constructor
    public PieceWorkerEmployee(int empID, MyName empName) {
        super(empID, empName, new MyDate(), new MyDate());
        totalPiecesFinished = 0;
        ratePerPiece = 0;
    }

    // Full constructor
    public PieceWorkerEmployee(int empID, MyName empName, MyDate birthDate, MyDate dateHired,
                               int totalPiecesFinished, double ratePerPiece) {
        super(empID, empName, birthDate, dateHired);
        setTotalPiecesFinished(totalPiecesFinished);
        setRatePerPiece(ratePerPiece);
    }

    // Getters and setters
    public int getTotalPiecesFinished() { return totalPiecesFinished; }
    public void setTotalPiecesFinished(int totalPiecesFinished) {
        if (totalPiecesFinished >= 0) this.totalPiecesFinished = totalPiecesFinished;
    }

    public double getRatePerPiece() { return ratePerPiece; }
    public void setRatePerPiece(double ratePerPiece) {
        if (ratePerPiece >= 0) this.ratePerPiece = ratePerPiece;
    }

    // Override computeSalary with bonus + birthday bonus
    @Override
    public double computeSalary(int currentMonth) {
        double basePay = totalPiecesFinished * ratePerPiece;
        int completeHundreds = totalPiecesFinished / 100;
        double bonusPay = completeHundreds * (10 * ratePerPiece);
        return basePay + bonusPay + super.computeSalary(currentMonth);
    }

    // Display method

    // toString override
    @Override
    public String toString() {
        return String.format("PieceWorkerEmployee [ID: %d, Name: %s, Pieces: %d, Rate: ₱%.2f, Total Salary: ₱%,.2f]",
                getEmpID(), getEmpName().getFullName(), totalPiecesFinished, ratePerPiece, computeSalary(-1));
    }


    // equals and hashCode
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (!(obj instanceof PieceWorkerEmployee)) return false;
        PieceWorkerEmployee other = (PieceWorkerEmployee) obj;
        return totalPiecesFinished == other.totalPiecesFinished &&
                Double.compare(ratePerPiece, other.ratePerPiece) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), totalPiecesFinished, ratePerPiece);
    }

    // clone
    @Override
    public PieceWorkerEmployee clone() {
        PieceWorkerEmployee copy = (PieceWorkerEmployee) super.clone();
        copy.totalPiecesFinished = this.totalPiecesFinished;
        copy.ratePerPiece = this.ratePerPiece;
        return copy;
    }
}
