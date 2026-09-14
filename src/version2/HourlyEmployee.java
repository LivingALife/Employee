package version2;

public class HourlyEmployee {

    private int empID;
    private MyName empName;
    private float totalHoursWorked;
    private double ratePerHour = 0;
    private MyDate birthDate;
    private MyDate dateHired;

    // Default Constructor
    public HourlyEmployee() {
        empID = 0;
        empName = new MyName();
        totalHoursWorked = 0;
        birthDate = new MyDate();
        dateHired = new MyDate();
    }

    // Partial Constructor
    public HourlyEmployee(int empID, MyName empName) {
        this.empID = empID;
        this.empName = empName;
        totalHoursWorked = 0;
        birthDate = new MyDate();
        dateHired = new MyDate();
    }

    // Full Constructor
    public HourlyEmployee(
            int empID,
            MyName empName,
            float totalHoursWorked,
            double ratePerHour) {

        this.empID = empID;
        this.empName = empName;
        setTotalHoursWorked(totalHoursWorked);
        setRatePerHour(ratePerHour);
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

    public float getTotalHoursWorked() {
        return totalHoursWorked;
    }

    public void setTotalHoursWorked(float totalHoursWorked) {
        if (totalHoursWorked >= 0) {
            this.totalHoursWorked = totalHoursWorked;
        }
    }

    public double getRatePerHour() {
        return ratePerHour;
    }

    public void setRatePerHour(double ratePerHour) {
        if (ratePerHour >= 0) {
            this.ratePerHour = ratePerHour;
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

        if (totalHoursWorked <= 40) {
            return totalHoursWorked * ratePerHour;
        }

        double regularPay = 40 * ratePerHour;

        double overtimePay =
                (totalHoursWorked - 40) * (ratePerHour * 1.5);

        return regularPay + overtimePay;
    }

    // Display Employee
    public void displayHourlyEmployee() {

        System.out.printf(
                "ID: %d | Name: %s | Hours: %.2f | Rate: \u20B1%.2f/hr | "
                        + "Birth Date: %s | Date Hired: %s%n",
                empID,
                empName.getFullName(),
                totalHoursWorked,
                ratePerHour,
                birthDate,
                dateHired
        );
    }

    // toString
    @Override
    public String toString() {

        return String.format(
                "HourlyEmployee [ID: %d, Name: %s, Hours: %.2f, "
                        + "Rate: $%.2f, Birth Date: %s, Date Hired: %s, "
                        + "Total Salary: $%,.2f]",
                empID,
                empName.getFullName(),
                totalHoursWorked,
                ratePerHour,
                birthDate,
                dateHired,
                computeSalary()
        );
    }
}