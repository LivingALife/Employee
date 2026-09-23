package version3;

public class MyDate {

    private int day;
    private int month;
    private int year;

    // Default Constructor
    public MyDate() {
        day = 1;
        month = 1;
        year = 2000;
    }

    // Full Constructor
    public MyDate(int day, int month, int year) {
        setDay(day);
        setMonth(month);
        setYear(year);
    }

    // Getters and Setters
    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if (day >= 1 && day <= 31) {
            this.day = day;
        }
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if (month >= 1 && month <= 12) {
            this.month = month;
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year >= 1900) {
            this.year = year;
        }
    }

    // Display Date
    public void displayMyDate() {

        System.out.printf(
                "%02d/%02d/%d%n",
                month,
                day,
                year
        );
    }

    // toString
    @Override
    public String toString() {

        return String.format(
                "%02d/%02d/%d",
                month,
                day,
                year
        );
    }

    @Override
    public MyDate clone() {
        try {
            return (MyDate) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
