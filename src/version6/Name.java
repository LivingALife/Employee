package version6;

public final class Name implements Cloneable {
    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;

    public Name(String firstName, String lastName) {
        this(firstName, "N/A", lastName, "");
    }

    public Name(String firstName, String middleName, String lastName) {
        this(firstName, middleName, lastName, "");
    }

    public Name(String firstName, String middleName, String lastName, String suffix) {
        setFirstName(firstName);
        setMiddleName(middleName);
        setLastName(lastName);
        setSuffix(suffix);
    }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.trim().isEmpty())
            throw new IllegalArgumentException("Name fields cannot be empty");
        this.firstName = firstName;
    }

    public String getMiddleName() { return middleName; }
    public void setMiddleName(String middleName) {
        this.middleName = (middleName == null) ? "N/A" : middleName;
    }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) {
        if (lastName == null || lastName.trim().isEmpty())
            throw new IllegalArgumentException("Name fields cannot be empty");
        this.lastName = lastName;
    }

    public String getSuffix() { return suffix; }
    public void setSuffix(String suffix) {
        this.suffix = (suffix == null) ? "" : suffix;
    }

    public String getFullName() {
        StringBuilder sb = new StringBuilder();
        sb.append(lastName).append(", ").append(firstName);
        if (middleName != null && !middleName.equalsIgnoreCase("N/A") && !middleName.isBlank()) {
            sb.append(" ").append(middleName.charAt(0)).append(".");
        }
        if (suffix != null && !suffix.isBlank()) {
            sb.append(" ").append(suffix);
        }
        return sb.toString();
    }

    @Override
    public String toString() { return getFullName(); }

    @Override
    public Name clone() {
        try {
            return (Name) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}