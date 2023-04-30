import java.util.List;

public interface EmployeeDAO {
    void addEmployee(Employee employee);

    Employee getEmployeeById(int id);

    List<Employee> getAllEmployee();


    void updateEmployee(Employee employee, Employee employee1);

    void deleteEmployee(Employee employee);


}
