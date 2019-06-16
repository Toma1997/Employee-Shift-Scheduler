package service.employee.EmployeeService;

public class Employee {
    private String firstName, lastName, email, phone, position;
    private int birthYear;
    private double yearsExperience;

    public Employee() {

    }

    public Employee(String firstName, String lastName, String email, String phone, String postion, int birthYear, double yearsExperience) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.position = postion;
        this.birthYear = birthYear;
        this.yearsExperience = yearsExperience;

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public double getYearsExperience() {
        return yearsExperience;
    }

    public void setYearsExperience(double yearsExperience) {
        this.yearsExperience = yearsExperience;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", position='" + position + '\'' +
                ", birthYear=" + birthYear +
                ", yearsExperience=" + yearsExperience +
                '}';
    }
}
