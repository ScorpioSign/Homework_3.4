import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {


    @Override
    public List<Employee> getAllEmployee() {
        EntityManager entityManager = EntityUtil.create();
        entityManager.getTransaction().begin();
        String jpqlQuery = "SELECT s FROM Employee s";
        TypedQuery<Employee> query = entityManager.createQuery(jpqlQuery, Employee.class);
        List<Employee> employees = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return employees;
    }


    @Override
    public void addEmployee(Employee employee) {
        EntityManager entityManager = EntityUtil.create();
        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("Сотрудник добавлен");
    }

    @Override
    public Employee getEmployeeById(int id) {
        EntityManager entityManager = EntityUtil.create();
        entityManager.getTransaction().begin();
        Employee employee = entityManager.find(Employee.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return employee;
    }

    @Override
    public void updateEmployee(Employee employee, Employee employee1) {
        EntityManager entityManager = EntityUtil.create();
        entityManager.getTransaction().begin();
        entityManager.merge(employee1);
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("Данные сотрудника ID" + employee.getId() + " обновлены");

    }

    @Override
    public void deleteEmployee(Employee employee) {
        EntityManager entityManager = EntityUtil.create();
        entityManager.getTransaction().begin();
        Employee employee1 = entityManager.find(Employee.class, employee.getId());
        entityManager.remove(employee1);
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("Сотрудник ID" + employee.getId() + " удален");
    }

}
