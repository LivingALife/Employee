package version4;

import java.util.Objects;

public class CommissionEmployee extends Employee {

    private double totalSale;

    // Default constructor
    public CommissionEmployee() {
        super();
        totalSale = 0;
    }

    // Partial constructor
    public CommissionEmployee(int empID, MyName empName) {
        super(empID, empName, new MyDate(), new MyDate());
        totalSale = 0;
    }

    // Full constructor
    public CommissionEmployee(int empID, MyName empName, MyDate birthDate, MyDate dateHired, double totalSale) {
        super(empID, empName, birthDate, dateHired);
        setTotalSale(totalSale);
    }

    // Getter and setter
    public double getTotalSale() { return totalSale; }
    public void setTotalSale(double totalSale) {
        if (totalSale >= 0) this.totalSale = totalSale;
    }

    // Commission rate logic
    public double getCommissionRate() {
        if (totalSale < 50000) return 0.05;
        else if (totalSale < 100000) return 0.10;
        else if (totalSale < 500000) return 0.15;
        else return 0.20;
    }

    // Override computeSalary with birthday bonus
    @Override
    public double computeSalary(int currentMonth) {
        return (totalSale * getCommissionRate()) + super.computeSalary(currentMonth);
    }

    // toString override
    @Override
    public String toString() {
        return String.format("CommissionEmployee [ID: %d, Name: %s, Sales: ₱%.2f, Commission Rate: %.0f%%, Total Salary: ₱%,.2f]",
                getEmpID(), getEmpName().getFullName(), totalSale, getCommissionRate() * 100, computeSalary(-1));
    }

    // equals and hashCode
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (!(obj instanceof CommissionEmployee)) return false;
        CommissionEmployee other = (CommissionEmployee) obj;
        return Double.compare(totalSale, other.totalSale) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), totalSale);
    }

    // clone
    @Override
    public CommissionEmployee clone() {
        CommissionEmployee copy = (CommissionEmployee) super.clone();
        copy.totalSale = this.totalSale;
        return copy;
    }
    public void displayCommissionEmployee() { System.out.println(this); }
}