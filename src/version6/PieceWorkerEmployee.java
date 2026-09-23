package version6;

import java.util.Objects;

public class PieceWorkerEmployee extends Employee {
    private int totalPiecesFinished;
    private double ratePerPiece;

    public PieceWorkerEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired,
                               int totalPiecesFinished, double ratePerPiece) {
        super(empID, empName, birthDate, dateHired);
        setTotalPiecesFinished(totalPiecesFinished);
        setRatePerPiece(ratePerPiece);
    }

    public int getTotalPiecesFinished() { return totalPiecesFinished; }
    public void setTotalPiecesFinished(int totalPiecesFinished) {
        if (totalPiecesFinished < 0)
            throw new IllegalArgumentException("Total pieces finished cannot be negative.");
        this.totalPiecesFinished = totalPiecesFinished;
    }

    public double getRatePerPiece() { return ratePerPiece; }
    public void setRatePerPiece(double ratePerPiece) {
        if (ratePerPiece < 0)
            throw new IllegalArgumentException("Rate per piece cannot be negative.");
        this.ratePerPiece = ratePerPiece;
    }

    @Override
    public double computeSalary(int currentMonth) {
        double basePay = totalPiecesFinished * ratePerPiece;
        int completeHundreds = totalPiecesFinished / 100;
        double bonusPay = completeHundreds * (10 * ratePerPiece);
        return basePay + bonusPay + getBirthdayBonus(currentMonth);
    }

    @Override
    public double computeSalary() { return computeSalary(-1); }

    @Override
    public void displayEmployee() { System.out.println(this); }

    @Override
    public String toString() {
        return String.format("PieceWorkerEmployee [ID: %d, Name: %s, Total Salary: ₱%,.2f]",
                getEmpID(), getEmpName().getFullName(), computeSalary(-1));
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (!(obj instanceof PieceWorkerEmployee)) return false;
        PieceWorkerEmployee other = (PieceWorkerEmployee) obj;
        return totalPiecesFinished == other.totalPiecesFinished &&
                Double.compare(ratePerPiece, other.ratePerPiece) == 0;
    }

    @Override
    public int hashCode() { return Objects.hash(super.hashCode(), totalPiecesFinished, ratePerPiece); }

    @Override
    public PieceWorkerEmployee clone() {
        PieceWorkerEmployee copy = (PieceWorkerEmployee) super.clone();
        copy.totalPiecesFinished = this.totalPiecesFinished;
        copy.ratePerPiece = this.ratePerPiece;
        return copy;
    }
}