package version5;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRoster {
    private List<Employee> empList;

    public EmployeeRoster() {
        empList = new ArrayList<>();
    }

    public EmployeeRoster(int initialCapacity) {
        empList = new ArrayList<>(initialCapacity);
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

    public Employee searchEmployee(int empID) {
        for (Employee emp : empList) {
            if (emp.getEmpID() == empID) return emp;
        }
        return null;
    }

    public int countEmployees() {
        return empList.size();
    }

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
            System.out.printf("ID: %d | Name: %s | Payout: ₱%,.2f%n",
                    emp.getEmpID(), emp.getEmpName().getFullName(), salary);
        }
    }

    public void displayAllEmployees() {
        int i = 1;
        for (Employee emp : empList) {
            System.out.println((i++) + ". " + emp);
        }
    }
}