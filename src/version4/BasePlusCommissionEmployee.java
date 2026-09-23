package version4;

import java.util.Objects;

public class BasePlusCommissionEmployee extends CommissionEmployee {

    private double baseSalary;

    // Default constructor
    public BasePlusCommissionEmployee() {
        super();
        baseSalary = 0;
    }

    // Partial constructor
    public BasePlusCommissionEmployee(int empID, MyName empName) {
        super(empID, empName);
        baseSalary = 0;
    }

    // Full constructor
    public BasePlusCommissionEmployee(int empID, MyName empName, MyDate birthDate, MyDate dateHired,
                                      double totalSale, double baseSalary) {
        super(empID, empName, birthDate, dateHired, totalSale);
        setBaseSalary(baseSalary);
    }

    // Getter and setter
    public double getBaseSalary() { return baseSalary; }
    public void setBaseSalary(double baseSalary) {
        if (baseSalary >= 0) this.baseSalary = baseSalary;
    }

    // Override computeSalary with base + commission + birthday bonus
    @Override
    public double computeSalary(int currentMonth) {
        return baseSalary + super.computeSalary(currentMonth);
    }

    // toString override
    @Override
    public String toString() {
        return String.format("BasePlusCommissionEmployee [ID: %d, Name: %s, Base Salary: ₱%.2f, Sales: ₱%.2f, Commission Rate: %.0f%%, Total Salary: ₱%,.2f]",
                getEmpID(), getEmpName().getFullName(), baseSalary, getTotalSale(), getCommissionRate() * 100, computeSalary(-1));
    }

    // equals and hashCode
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (!(obj instanceof BasePlusCommissionEmployee)) return false;
        BasePlusCommissionEmployee other = (BasePlusCommissionEmployee) obj;
        return Double.compare(baseSalary, other.baseSalary) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), baseSalary);
    }

    // clone
    @Override
    public BasePlusCommissionEmployee clone() {
        BasePlusCommissionEmployee copy = (BasePlusCommissionEmployee) super.clone();
        copy.baseSalary = this.baseSalary;
        return copy;
    }
    public void displayBasePlusCommissionEmployee() { System.out.println(this); }
}
