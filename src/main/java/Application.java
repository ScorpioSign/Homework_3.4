import java.sql.*;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        final String user = "postgres";
        final String password = "6101_286303";
        final String url = "jdbc:postgresql://localhost:5432/skypro";
        //задание 1
        try (final Connection connection =
                     DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee JOIN city ON employee.city_id = city.id")) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int idEmployee = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String gender = resultSet.getString("gender");
                int ageEmployee = resultSet.getInt("age");
                String city = resultSet.getString("name");

                if (idEmployee == 5) {
                    System.out.println("ID " + idEmployee);
                    System.out.println("Имя " + firstName);
                    System.out.println("Фамилия " + lastName);
                    System.out.println("Пол " + gender);
                    System.out.println("Город " + city);
                }
            }

        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к базе данных!");
            e.printStackTrace();
        }
        // задание 2
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        Employee employees = new Employee(10, "Olga", "Berezina", "female", 45, 2);
        employeeDAO.addEmployee(employees);
        System.out.println(employeeDAO.getEmployeeById(1));
        System.out.println();
        employeeDAO.updateEmployee(6, "Petr", "Petrov", "male", 31, 5);
        employeeDAO.deleteEmployee(9);

        List<Employee> employeeList = employeeDAO.getAllEmployee();

        for (Employee employee : employeeList) {
            System.out.println(employee);

        }


    }
}
