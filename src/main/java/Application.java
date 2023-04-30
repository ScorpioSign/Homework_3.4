
import java.util.List;

public class Application {
    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        CityDAO cityDAO = new CityDAOImpl();

        City city = new City();
        city.setName("Tver");
        cityDAO.addCity(city);

        City city1 = new City();
        city1.setName("Krasnodar");
        cityDAO.addCity(city1);

        City city2 = new City();
        city2.setName("Omsk");
        cityDAO.addCity(city2);

        Employee employee = new Employee();
        employee.setFirstName("Egor");
        employee.setLastName("Egorov");
        employee.setGender("male");
        employee.setAge(54);
        employee.setCity(cityDAO.getCityById(42));
        employeeDAO.addEmployee(employee);

        Employee employee1 = new Employee();
        employee1.setFirstName("Ivan");
        employee1.setLastName("Ivanov");
        employee1.setGender("male");
        employee1.setAge(35);
        employee1.setCity(cityDAO.getCityById(42));
        employeeDAO.addEmployee(employee1);

        Employee employee2 = new Employee();
        employee2.setFirstName("Leonid");
        employee2.setLastName("Leonidov");
        employee2.setGender("male");
        employee2.setAge(43);
        employee2.setCity(cityDAO.getCityById(42));
        employeeDAO.addEmployee(employee2);

        City cityUpd = new City();
        cityUpd.setCityId(2);
        cityUpd.setName("Ryazan");
        cityDAO.updateCity(cityUpd);

        cityDAO.deleteCity(cityDAO.getCityById(42));

        System.out.println("Список сотрудников: ");
        List<Employee> employeeList = employeeDAO.getAllEmployee();
        for (Employee employees1 : employeeList) {
            System.out.println(employees1);
        }

        System.out.println("Список городов: ");
        List<City> cityList = cityDAO.getAllCity();
        for (City cities : cityList) {
            System.out.println(cities);
        }


        EntityUtil.closeEntityManagerFactory();

    }
}
