package version5;

import java.util.Objects;

public class Employee implements Cloneable {
    private int empID;
    private MyName empName;
    private MyDate birthDate;
    private MyDate dateHired;

    public Employee() {
        empID = 0;
        empName = new MyName();
        birthDate = new MyDate();
        dateHired = new MyDate();
    }

    public Employee(int empID, MyName empName, MyDate birthDate, MyDate dateHired) {
        this.empID = empID;
        this.empName = empName;
        this.birthDate = birthDate;
        this.dateHired = dateHired;
    }

    public int getEmpID() { return empID; }
    public MyName getEmpName() { return empName; }
    public MyDate getBirthDate() { return birthDate; }
    public MyDate getDateHired() { return dateHired; }

    public double computeSalary(int currentMonth) {
        return 0.0;
    }

    public double computeSalary() {
        return computeSalary(-1);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Employee)) return false;
        Employee other = (Employee) obj;
        return this.empID == other.empID;
    }

    @Override
    public int hashCode() { return Objects.hash(empID); }

    @Override
    public Employee clone() {
        try {
            Employee copy = (Employee) super.clone();
            copy.empName = empName.clone();
            copy.birthDate = birthDate.clone();
            copy.dateHired = dateHired.clone();
            return copy;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}