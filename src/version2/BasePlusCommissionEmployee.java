package version2;

public class BasePlusCommissionEmployee {

    private int empID;
    private MyName empName;
    private double totalSale;
    private double baseSalary;
    private MyDate birthDate;
    private MyDate dateHired;

    // Default Constructor
    public BasePlusCommissionEmployee() {
        empID = 0;
        empName = new MyName();
        totalSale = 0;
        baseSalary = 0;
        birthDate = new MyDate();
        dateHired = new MyDate();
    }

    // Partial Constructor
    public BasePlusCommissionEmployee(
            int empID,
            MyName empName) {

        this.empID = empID;
        this.empName = empName;
        totalSale = 0;
        baseSalary = 0;
        birthDate = new MyDate();
        dateHired = new MyDate();
    }

    // Full Constructor
    public BasePlusCommissionEmployee(
            int empID,
            MyName empName,
            double totalSale,
            double baseSalary) {

        this.empID = empID;
        this.empName = empName;
        setTotalSale(totalSale);
        setBaseSalary(baseSalary);
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

    public double getTotalSale() {
        return totalSale;
    }

    public void setTotalSale(double totalSale) {
        if (totalSale >= 0) {
            this.totalSale = totalSale;
        }
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        if (baseSalary >= 0) {
            this.baseSalary = baseSalary;
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

    // Get Commission Rate
    public double getCommissionRate() {

        if (totalSale < 50000) {
            return 0.05;
        } else if (totalSale < 100000) {
            return 0.10;
        } else if (totalSale < 500000) {
            return 0.15;
        } else {
            return 0.20;
        }
    }

    // Compute Salary
    public double computeSalary() {

        return baseSalary + (totalSale * getCommissionRate());
    }

    // Display Employee
    public void displayBasePlusCommissionEmployee() {

        System.out.printf(
                "ID: %d | Name: %s | Total Sale: \u20B1%.2f | "
                        + "Base Salary: \u20B1%.2f | Birth Date: %s | "
                        + "Date Hired: %s%n",
                empID,
                empName.getFullName(),
                totalSale,
                baseSalary,
                birthDate,
                dateHired
        );
    }

    // toString
    @Override
    public String toString() {

        return String.format(
                "BasePlusCommissionEmployee [ID: %d, Name: %s, "
                        + "Sales: \u20B1%.2f, Base Salary: \u20B1%.2f, "
                        + "Commission Rate: %.0f%%, Birth Date: %s, "
                        + "Date Hired: %s, Total Salary: \u20B1%,.2f]",
                empID,
                empName.getFullName(),
                totalSale,
                baseSalary,
                getCommissionRate() * 100,
                birthDate,
                dateHired,
                computeSalary()
        );
    }
}