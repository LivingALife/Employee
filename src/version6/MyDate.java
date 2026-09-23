package version6;

public final class MyDate implements Cloneable {
    private int day;
    private int month;
    private int year;

    public MyDate() {
        this.year = 2000;
        this.month = 1;
        this.day = 1;
    }

    public MyDate(int day, int month, int year) {
        setYear(year);
        setMonth(month);
        setDay(day);
    }

    public int getDay() { return day; }
    public int getMonth() { return month; }
    public int getYear() { return year; }

    public void setYear(int year) {
        if (year <= 1900)
            throw new IllegalArgumentException("Invalid calendar date");
        this.year = year;
    }

    public void setMonth(int month) {
        if (month < 1 || month > 12)
            throw new IllegalArgumentException("Invalid calendar date");
        this.month = month;
    }

    public void setDay(int day) {
        int maxDay = daysInMonth(this.month, this.year);
        if (day < 1 || day > maxDay)
            throw new IllegalArgumentException("Invalid day for the specified month.");
        this.day = day;
    }

    private int daysInMonth(int month, int year) {
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12: return 31;
            case 4: case 6: case 9: case 11: return 30;
            case 2: return isLeapYear(year) ? 29 : 28;
            default: return 31;
        }
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    private static final String[] MONTH_NAMES = {
            "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
    };

    public String toShortFormat() {
        return String.format("%d %s %d", day, MONTH_NAMES[month - 1], year);
    }

    @Override
    public String toString() {
        return String.format("%02d/%02d/%d", month, day, year);
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