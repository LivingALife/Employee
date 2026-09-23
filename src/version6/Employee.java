package version6;

import java.util.Objects;

public abstract class Employee implements Cloneable {
    private final int empID;
    private Name empName;
    private MyDate birthDate;
    private MyDate dateHired;

    public Employee(int empID, Name empName, MyDate birthDate, MyDate dateHired) {
        if (empName == null) throw new NullPointerException("Employee name cannot be null");
        if (birthDate == null) throw new NullPointerException("Birth date cannot be null");
        if (dateHired == null) throw new NullPointerException("Date hired cannot be null");
        this.empID = empID;
        this.empName = empName.clone();
        this.birthDate = birthDate.clone();
        this.dateHired = dateHired.clone();
    }

    public final int getEmpID() { return empID; }
    public Name getEmpName() { return this.empName.clone(); }
    public MyDate getBirthDate() { return this.birthDate.clone(); }
    public MyDate getDateHired() { return this.dateHired.clone(); }

    public void setEmpName(Name empName) {
        if (empName == null) throw new NullPointerException("Employee name cannot be null");
        this.empName = empName.clone();
    }

    public void setBirthDate(MyDate birthDate) {
        if (birthDate == null) throw new NullPointerException("Birth date cannot be null");
        this.birthDate = birthDate.clone();
    }

    public void setDateHired(MyDate dateHired) {
        if (dateHired == null) throw new NullPointerException("Date hired cannot be null");
        this.dateHired = dateHired.clone();
    }

    public final double getBirthdayBonus(int currentMonth) {
        return (this.birthDate.getMonth() == currentMonth) ? 5000.00 : 0.0;
    }

    public abstract double computeSalary(int currentMonth);
    public abstract double computeSalary();
    public abstract void displayEmployee();

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
            copy.empName = this.empName.clone();
            copy.birthDate = this.birthDate.clone();
            copy.dateHired = this.dateHired.clone();
            return copy;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}