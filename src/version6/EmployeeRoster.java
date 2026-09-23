package version6;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRoster {
    private List<Employee> empList;

    public EmployeeRoster() {
        empList = new ArrayList<>();
    }

    public boolean addEmployee(Employee emp) {
        if (emp == null) return false;
        empList.add(emp);
        return true;
    }

    public Employee removeEmployee(int empID) {
        for (int i = 0; i < empList.size(); i++) {
            if (empList.get(i).getEmpID() == empID) {
                return empList.remove(i);
            }
        }
        return null;
    }

    public int countEmployees() { return empList.size(); }

    public int countHE() {
        int n = 0;
        for (Employee emp : empList) if (emp instanceof HourlyEmployee) n++;
        return n;
    }

    public int countPWE() {
        int n = 0;
        for (Employee emp : empList) if (emp instanceof PieceWorkerEmployee) n++;
        return n;
    }

    public int countCE() {
        int n = 0;
        for (Employee emp : empList) if (emp.getClass() == CommissionEmployee.class) n++;
        return n;
    }

    public int countBPCE() {
        int n = 0;
        for (Employee emp : empList) if (emp instanceof BasePlusCommissionEmployee) n++;
        return n;
    }

    public void displayPayroll(int currentMonth) {
        for (Employee emp : empList) {
            double salary = emp.computeSalary(currentMonth);
            boolean bonus = emp.getBirthDate().getMonth() == currentMonth;
            System.out.printf("ID: %-5d| Name: %-28s| Payout: ₱%,.2f%s%n",
                    emp.getEmpID(), emp.getEmpName().getFullName(), salary,
                    bonus ? " (Bonus Applied)" : "");
        }
    }
}