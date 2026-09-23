package version5;

import java.util.Objects;

public class BasePlusCommissionEmployee extends CommissionEmployee {
    private double baseSalary;

    public BasePlusCommissionEmployee() {
        super();
        baseSalary = 0;
    }

    public BasePlusCommissionEmployee(int empID, MyName empName) {
        super(empID, empName);
        baseSalary = 0;
    }

    public BasePlusCommissionEmployee(int empID, MyName empName, MyDate birthDate, MyDate dateHired,
                                      double totalSale, double baseSalary) {
        super(empID, empName, birthDate, dateHired, totalSale);
        setBaseSalary(baseSalary);
    }

    public double getBaseSalary() { return baseSalary; }
    public void setBaseSalary(double baseSalary) { if (baseSalary >= 0) this.baseSalary = baseSalary; }

    @Override
    public double computeSalary(int currentMonth) {
        // base + commission, no double birthday bonus (CommissionEmployee.computeSalary already adds it)
        double commissionPortion = getTotalSale() * getCommissionRate();
        double salary = baseSalary + commissionPortion;
        if (getBirthDate().getMonth() == currentMonth) salary += 5000.00;
        return salary;
    }

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

    public void displayBasePlusCommissionEmployee() { System.out.println(this); }
}