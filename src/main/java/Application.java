

import java.util.List;

public class Application {
    public static void main(String[] args) {


        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        Employee employee = new Employee();
        employee.setId(16);
        employee.setFirstName("Anna");
        employee.setLastName("Dubova");
        employee.setGender("female");
        employee.setAge(40);
        employee.setCityId(1);
        employeeDAO.addEmployee(employee);
        System.out.println();


        Employee employee1 = new Employee();
        employee1.setId(11);
        employee1.setFirstName("Svetlana");
        employee1.setLastName("Sergeeva");
        employee1.setGender("female");
        employee1.setAge(25);
        employee1.setCityId(1);
        employeeDAO.updateEmployee(employeeDAO.getEmployeeById(11), employee1);
        System.out.println();

        System.out.println("Сотрудник ID №2 " + employeeDAO.getEmployeeById(2));


        employeeDAO.deleteEmployee(employeeDAO.getEmployeeById(11));
        System.out.println();


        List<Employee> employeeList = employeeDAO.getAllEmployee();
        for (Employee employees : employeeList) {
            System.out.println(employees);
        }

        EntityUtil.closeEntityManagerFactory();
    }
}
