import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    final String user = "postgres";
    final String password = "6101_286303";
    final String url = "jdbc:postgresql://localhost:5432/skypro";

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> employees = new ArrayList<>();


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
                int cityId = resultSet.getInt("city_id");
                employees.add(new Employee(idEmployee, firstName, lastName, gender, ageEmployee, cityId));

            }
        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к базе данных!");
            e.printStackTrace();
        }
        return employees;
    }


    @Override
    public void addEmployee(Employee employee) {
        String sql = "INSERT INTO employee (first_name, last_name, gender, age, city_id) VALUES ('" + employee.getFirst_name() + "', '" + employee.getLast_name() + "', '" + employee.getGender() + "', " + employee.getAge() + ", " + employee.getCityId() + ")";
        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            System.out.println("Сотрудник добавлен");
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к БД");
            e.printStackTrace();
        }
    }

    @Override
    public Employee getEmployeeById(int id) {
        String sql = "SELECT * FROM employee WHERE id=" + id;
        Employee employee = null;
        try (final Connection connection =
                     DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int idEmployee = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String gender = resultSet.getString("gender");
                int ageEmployee = resultSet.getInt("age");
                int cityId = resultSet.getInt("city_id");

                if (idEmployee == id) {
                    employee = new Employee(id, firstName, lastName, gender, ageEmployee, cityId);

                }

            }
        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к базе данных!");
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public void updateEmployee(int id) {
        String sql = "UPDATE employee SET first_name = 'Ivan' WHERE id =" + id;
        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            System.out.println("Сотрудник изменен");
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к БД");
            e.printStackTrace();
        }

    }

    @Override
    public void deleteEmployee(int id) {
        String sql = "DELETE FROM employee WHERE id=" + id;
        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            System.out.println("Сотрудник удален");
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к БД");
            e.printStackTrace();
        }
    }

}
