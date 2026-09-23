package version1;

public class BasePlusCommissionEmployee {

    private int empID;
    private String empName;
    private double totalSale;
    private double baseSalary;

    // Default Constructor
    public BasePlusCommissionEmployee() {
        empID = 0;
        empName = "N/A";
        totalSale = 0;
        baseSalary = 0;
    }

    // Partial Constructor
    public BasePlusCommissionEmployee(
            int empID,
            String empName) {

        this.empID = empID;
        this.empName = empName;
        totalSale = 0;
        baseSalary = 0;
    }

    // Full Constructor
    public BasePlusCommissionEmployee(
            int empID,
            String empName,
            double totalSale,
            double baseSalary) {

        this.empID = empID;
        this.empName = empName;
        setTotalSale(totalSale);
        setBaseSalary(baseSalary);
    }

    // Getters and Setters
    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
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
                        + "Base Salary: \u20B1%.2f%n",
                empID,
                empName,
                totalSale,
                baseSalary
        );
    }

    // toString
    @Override
    public String toString() {

        return String.format(
                "BasePlusCommissionEmployee [ID: %d, Name: %s, "
                        + "Sales: \u20B1%.2f, Base Salary: \u20B1%.2f, "
                        + "Commission Rate: %.0f%%, Total Salary: \u20B1%,.2f]",
                empID,
                empName,
                totalSale,
                baseSalary,
                getCommissionRate() * 100,
                computeSalary()
        );
    }
}
