package version3;

import java.util.Objects;

public class HourlyEmployee extends version3.Employee {

    private float totalHoursWorked;
    private double ratePerHour;

    // Default constructor
    public HourlyEmployee() {
        super();
        totalHoursWorked = 0;
        ratePerHour = 0;
    }

    // Partial constructor
    public HourlyEmployee(int empID, MyName empName) {
        super(empID, empName, new MyDate(), new MyDate());
        totalHoursWorked = 0;
        ratePerHour = 0;
    }

    // Full constructor
    public HourlyEmployee(int empID, MyName empName, MyDate birthDate, MyDate dateHired,
                          float totalHoursWorked, double ratePerHour) {
        super(empID, empName, birthDate, dateHired);
        setTotalHoursWorked(totalHoursWorked);
        setRatePerHour(ratePerHour);
    }

    // Getters and setters
    public float getTotalHoursWorked() { return totalHoursWorked; }
    public void setTotalHoursWorked(float totalHoursWorked) {
        if (totalHoursWorked >= 0) this.totalHoursWorked = totalHoursWorked;
    }

    public double getRatePerHour() { return ratePerHour; }
    public void setRatePerHour(double ratePerHour) {
        if (ratePerHour >= 0) this.ratePerHour = ratePerHour;
    }

    // Override computeSalary with birthday bonus
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
        return salary + super.computeSalary(currentMonth);
    }

    // toString override
    @Override
    public String toString() {
        return String.format("HourlyEmployee [ID: %d, Name: %s, Hours: %.2f, Rate: ₱%.2f/hr, Total Salary: ₱%,.2f]",
                getEmpID(), getEmpName().getFullName(), totalHoursWorked, ratePerHour, computeSalary(-1));
    }

    // equals and hashCode
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (!(obj instanceof HourlyEmployee)) return false;
        HourlyEmployee other = (HourlyEmployee) obj;
        return Float.compare(totalHoursWorked, other.totalHoursWorked) == 0 &&
                Double.compare(ratePerHour, other.ratePerHour) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), totalHoursWorked, ratePerHour);
    }

    // clone
    @Override
    public HourlyEmployee clone() {
        HourlyEmployee copy = (HourlyEmployee) super.clone();
        copy.totalHoursWorked = this.totalHoursWorked;
        copy.ratePerHour = this.ratePerHour;
        return copy;
    }

}
