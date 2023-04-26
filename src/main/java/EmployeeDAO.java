import java.util.List;

public interface EmployeeDAO {
    void addEmployee(Employee employee);

    Employee getEmployeeById(int id);

    List<Employee> getAllEmployee();

    //void updateEmployee(int id, String first_name, String last_name, String gender, int age, int cityId);
    void updateEmployee(Employee employee, Employee employee1);

    void deleteEmployee(Employee employee);


}
