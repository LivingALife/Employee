package version6;

import java.util.Objects;

public class HourlyEmployee extends Employee {
    private float totalHoursWorked;
    private double ratePerHour;

    public HourlyEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired,
                          float totalHoursWorked, double ratePerHour) {
        super(empID, empName, birthDate, dateHired);
        setTotalHoursWorked(totalHoursWorked);
        setRatePerHour(ratePerHour);
    }

    public float getTotalHoursWorked() { return totalHoursWorked; }
    public void setTotalHoursWorked(float totalHoursWorked) {
        if (totalHoursWorked < 0)
            throw new IllegalArgumentException("Total hours worked cannot be negative.");
        this.totalHoursWorked = totalHoursWorked;
    }

    public double getRatePerHour() { return ratePerHour; }
    public void setRatePerHour(double ratePerHour) {
        if (ratePerHour < 0)
            throw new IllegalArgumentException("Rate per hour cannot be negative.");
        this.ratePerHour = ratePerHour;
    }

    @Override
    public double computeSalary(int currentMonth) {
        double salary;
        if (totalHoursWorked <= 40) {
            salary = totalHoursWorked * ratePerHour;
        } else {
            double regularPay = 40 * ratePerHour;
            double overtimePay = (totalHoursWorked - 40) * (ratePerHour * 1.5);
            salary = regularPay + overtimePay;
        }
        return salary + getBirthdayBonus(currentMonth);
    }

    @Override
    public double computeSalary() { return computeSalary(-1); }

    @Override
    public void displayEmployee() { System.out.println(this); }

    @Override
    public String toString() {
        return String.format("HourlyEmployee [ID: %d, Name: %s, Total Salary: ₱%,.2f]",
                getEmpID(), getEmpName().getFullName(), computeSalary(-1));
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (!(obj instanceof HourlyEmployee)) return false;
        HourlyEmployee other = (HourlyEmployee) obj;
        return Float.compare(totalHoursWorked, other.totalHoursWorked) == 0 &&
                Double.compare(ratePerHour, other.ratePerHour) == 0;
    }

    @Override
    public int hashCode() { return Objects.hash(super.hashCode(), totalHoursWorked, ratePerHour); }

    @Override
    public HourlyEmployee clone() {
        HourlyEmployee copy = (HourlyEmployee) super.clone();
        copy.totalHoursWorked = this.totalHoursWorked;
        copy.ratePerHour = this.ratePerHour;
        return copy;
    }
}