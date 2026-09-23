package version6;

import java.util.Objects;

public final class BasePlusCommissionEmployee extends CommissionEmployee {
    private double baseSalary;

    public BasePlusCommissionEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired,
                                      double totalSale, double baseSalary) {
        super(empID, empName, birthDate, dateHired, totalSale);
        setBaseSalary(baseSalary);
    }

    public double getBaseSalary() { return baseSalary; }
    public void setBaseSalary(double baseSalary) {
        if (baseSalary < 0)
            throw new IllegalArgumentException("Base salary cannot be negative.");
        this.baseSalary = baseSalary;
    }

    @Override
    public double computeSalary(int currentMonth) {
        return baseSalary + super.computeSalary(currentMonth);
    }

    @Override
    public void displayEmployee() { System.out.println(this); }

    @Override
    public String toString() {
        return String.format("BasePlusCommissionEmployee [ID: %d, Name: %s, Total Salary: ₱%,.2f]",
                getEmpID(), getEmpName().getFullName(), computeSalary(-1));
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (!(obj instanceof BasePlusCommissionEmployee)) return false;
        BasePlusCommissionEmployee other = (BasePlusCommissionEmployee) obj;
        return Double.compare(baseSalary, other.baseSalary) == 0;
    }

    @Override
    public int hashCode() { return Objects.hash(super.hashCode(), baseSalary); }

    @Override
    public BasePlusCommissionEmployee clone() {
        BasePlusCommissionEmployee copy = (BasePlusCommissionEmployee) super.clone();
        copy.baseSalary = this.baseSalary;
        return copy;
    }
}