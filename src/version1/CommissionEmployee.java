package version1;

public class CommissionEmployee {

    private int empID;
    private String empName;
    private double totalSale;

    // Default Constructor
    public CommissionEmployee() {
        empID = 0;
        empName = "N/A";
        totalSale = 0;
    }

    // Partial Constructor
    public CommissionEmployee(int empID, String empName) {
        this.empID = empID;
        this.empName = empName;
        totalSale = 0;
    }

    // Full Constructor
    public CommissionEmployee(
            int empID,
            String empName,
            double totalSale) {

        this.empID = empID;
        this.empName = empName;
        setTotalSale(totalSale);
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

        return totalSale * getCommissionRate();
    }

    // Display Employee
    public void displayCommissionEmployee() {

        System.out.printf(
                "ID: %d | Name: %s | Total Sale: \u20B1%.2f%n",
                empID,
                empName,
                totalSale
        );
    }

    // toString
    @Override
    public String toString() {

        return String.format(
                "CommissionEmployee [ID: %d, Name: %s, "
                        + "Total Sale: \u20B1%.2f, Commission Rate: %.0f%%, "
                        + "Total Salary: \u20B1%,.2f]",
                empID,
                empName,
                totalSale,
                getCommissionRate() * 100,
                computeSalary()
        );
    }
}