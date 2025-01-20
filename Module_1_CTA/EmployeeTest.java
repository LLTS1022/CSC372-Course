package Module_1_CTA;

public class EmployeeTest {
    public static void main(String[] args) {
        System.out.println("Creating and testing Employee object:");
        Employee employee = new Employee("John", "Doe", 1001);
        employee.setSalary(50000.00);
        employee.employeeSummary();

        System.out.println("\n" + repeatChar("=", 50) + "\n");

        System.out.println("Creating and testing Manager object:");
        Manager manager = new Manager("Jane", "Smith", 2001, "Engineering");
        manager.setSalary(85000.00);
        manager.employeeSummary();

        System.out.println("\n" + repeatChar("=", 50) + "\n");

        System.out.println("Demonstrating polymorphism:");
        Employee employeeRef = new Manager("Bob", "Johnson", 2002, "Finance");
        employeeRef.setSalary(90000.00);
        employeeRef.employeeSummary();
    }

    
    public static String repeatChar(String str, int count) {
        StringBuilder repeated = new StringBuilder();
        for (int i = 0; i < count; i++) {
            repeated.append(str);
        }
        return repeated.toString();
    }
}
