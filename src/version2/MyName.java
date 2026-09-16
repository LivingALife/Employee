package version2;

public class MyName {

    private String firstName;
    private String middleName;
    private String lastName;

    // Default Constructor
    public MyName() {
        firstName = "N/A";
        middleName = "N/A";
        lastName = "N/A";
    }

    // Partial Constructor
    public MyName(String firstName, String lastName) {
        this.firstName = firstName;
        this.middleName = "N/A";
        this.lastName = lastName;
    }

    // Full Constructor
    public MyName(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    // Getters and Setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Get Full Name
    public String getFullName() {
        return firstName + " " + middleName + " " + lastName;
    }

    // Display Name
    public void displayMyName() {
        System.out.println(getFullName());
    }

    // toString
    @Override
    public String toString() {
        return getFullName();
    }
}