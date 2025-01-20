package Module_1_CTA;

public class Employee {
    private String firstName;
    private String lastName;
    private int employeeID;
    private double salary;

  
    public Employee() {
        this.salary = 0.0;
    }

    public Employee(String firstName, String lastName, int employeeID) {
        this();  
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeID = employeeID;
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

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

   
    public void employeeSummary() {
        System.out.println("Employee Summary:");
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Salary: $" + String.format("%.2f", salary));
    }
}
