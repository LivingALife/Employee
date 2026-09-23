package version5;

import java.util.Objects;

public class PieceWorkerEmployee extends Employee {
    private int totalPiecesFinished;
    private double ratePerPiece;

    public PieceWorkerEmployee() {
        super();
        totalPiecesFinished = 0;
        ratePerPiece = 0;
    }

    public PieceWorkerEmployee(int empID, MyName empName) {
        super(empID, empName, new MyDate(), new MyDate());
        totalPiecesFinished = 0;
        ratePerPiece = 0;
    }

    public PieceWorkerEmployee(int empID, MyName empName, MyDate birthDate, MyDate dateHired,
                               int totalPiecesFinished, double ratePerPiece) {
        super(empID, empName, birthDate, dateHired);
        setTotalPiecesFinished(totalPiecesFinished);
        setRatePerPiece(ratePerPiece);
    }

    public int getTotalPiecesFinished() { return totalPiecesFinished; }
    public void setTotalPiecesFinished(int totalPiecesFinished) { if (totalPiecesFinished >= 0) this.totalPiecesFinished = totalPiecesFinished; }
    public double getRatePerPiece() { return ratePerPiece; }
    public void setRatePerPiece(double ratePerPiece) { if (ratePerPiece >= 0) this.ratePerPiece = ratePerPiece; }

    @Override
    public double computeSalary(int currentMonth) {
        double basePay = totalPiecesFinished * ratePerPiece;
        int completeHundreds = totalPiecesFinished / 100;
        double bonusPay = completeHundreds * (10 * ratePerPiece);
        double salary = basePay + bonusPay;
        if (getBirthDate().getMonth() == currentMonth) salary += 5000.00;
        return salary;
    }

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

    public void displayPieceWorkerEmployee() { System.out.println(this); }
}