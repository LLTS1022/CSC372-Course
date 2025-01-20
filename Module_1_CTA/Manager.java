package Module_1_CTA;


public class Manager extends Employee {
    private String department;

    
    public Manager() {
        super();
    }

    
    public Manager(String firstName, String lastName, int employeeID, String department) {
        super(firstName, lastName, employeeID);
        this.department = department;
    }

   
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

   
    @Override
    public void employeeSummary() {
        super.employeeSummary();  
        System.out.println("Department: " + department);
        System.out.println("Position: Manager");
    }
}
