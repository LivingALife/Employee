package version4;

public class EmployeeRoster {
    private Employee[] empList;
    private int max;
    private int count;

    public EmployeeRoster() {
        max = 10;
        empList = new Employee[max];
        count = 0;
    }

    public EmployeeRoster(int max) {
        this.max = max;
        empList = new Employee[this.max];
        count = 0;
    }

    public boolean addEmployee(Employee emp) {
        if (emp == null || count >= max) return false;
        empList[count] = emp;
        count++;
        return true;
    }

    public Employee removeEmployee(int empID) {
        for (int i = 0; i < count; i++) {
            if (empList[i].getEmpID() == empID) {
                Employee removed = empList[i];
                for (int j = i; j < count - 1; j++) {
                    empList[j] = empList[j + 1];
                }
                empList[count - 1] = null;
                count--;
                return removed;
            }
        }
        return null;
    }

    public Employee searchEmployee(int empID) {
        for (int i = 0; i < count; i++) {
            if (empList[i].getEmpID() == empID) return empList[i];
        }
        return null;
    }

    public int countHE() {
        int n = 0;
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof HourlyEmployee) n++;
        }
        return n;
    }

    public int countPWE() {
        int n = 0;
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof PieceWorkerEmployee) n++;
        }
        return n;
    }

    public int countCE() {
        int n = 0;
        for (int i = 0; i < count; i++) {
            // Strict CommissionEmployee only — exclude the BasePlusCommissionEmployee subclass
            if (empList[i].getClass() == CommissionEmployee.class) n++;
        }
        return n;
    }

    public int countBPCE() {
        int n = 0;
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof BasePlusCommissionEmployee) n++;
        }
        return n;
    }

    public void displayHE() {
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof HourlyEmployee he) {
                he.displayHourlyEmployee();
            }
        }
    }

    public void displayPWE() {
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof PieceWorkerEmployee pwe) {
                pwe.displayPieceWorkerEmployee();
            }
        }
    }

    public void displayCE() {
        for (int i = 0; i < count; i++) {
            // Strict CommissionEmployee only, same caveat as countCE()
            if (empList[i].getClass() == CommissionEmployee.class) {
                ((CommissionEmployee) empList[i]).displayCommissionEmployee();
            }
        }
    }

    public void displayBPCE() {
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof BasePlusCommissionEmployee bpce) {
                bpce.displayBasePlusCommissionEmployee();
            }
        }
    }

    public void displayAllEmployees() {
        for (int i = 0; i < count; i++) {
            Employee e = empList[i];
            System.out.printf("%d. ID: %d | Name: %s | Type: %s%n",
                    i + 1, e.getEmpID(), e.getEmpName().getFullName(), e.getClass().getSimpleName());
        }
    }

    public void displayPayroll(int currentMonth) {
        for (int i = 0; i < count; i++) {
            Employee e = empList[i];
            boolean birthdayBonus = e.getBirthDate().getMonth() == currentMonth;

            if (e instanceof BasePlusCommissionEmployee bpce) {
                System.out.printf("[Base Plus Commission] ID: %d | Name: %s | Salary: ₱%,.2f%s%n",
                        bpce.getEmpID(), bpce.getEmpName().getFullName(), bpce.computeSalary(currentMonth),
                        birthdayBonus ? " (Birthday Bonus Applied)" : "");
            } else if (e instanceof CommissionEmployee ce) {
                System.out.printf("[Commission] ID: %d | Name: %s | Salary: ₱%,.2f%s%n",
                        ce.getEmpID(), ce.getEmpName().getFullName(), ce.computeSalary(currentMonth),
                        birthdayBonus ? " (Birthday Bonus Applied)" : "");
            } else if (e instanceof HourlyEmployee he) {
                System.out.printf("[Hourly] ID: %d | Name: %s | Salary: ₱%,.2f%s%n",
                        he.getEmpID(), he.getEmpName().getFullName(), he.computeSalary(currentMonth),
                        birthdayBonus ? " (Birthday Bonus Applied)" : "");
            } else if (e instanceof PieceWorkerEmployee pwe) {
                System.out.printf("[Piece Worker] ID: %d | Name: %s | Salary: ₱%,.2f%s%n",
                        pwe.getEmpID(), pwe.getEmpName().getFullName(), pwe.computeSalary(currentMonth),
                        birthdayBonus ? " (Birthday Bonus Applied)" : "");
            }
        }
    }
}