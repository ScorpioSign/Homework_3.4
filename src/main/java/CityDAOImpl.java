import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;


public class CityDAOImpl implements CityDAO {

    public List<City> getAllCity() {
        EntityManager entityManager = EntityUtil.create();
        entityManager.getTransaction().begin();
        String jpqlQuery = "SELECT s FROM City s";
        TypedQuery<City> query = entityManager.createQuery(jpqlQuery, City.class);
        List<City> cities = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return cities;
    }

    public void addCity(City city) {
        EntityManager entityManager = EntityUtil.create();
        entityManager.getTransaction().begin();
        entityManager.persist(city);
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("Город ID" + city.getCityId() + "добавлен");
    }


    public void updateCity(City city) {
        EntityManager entityManager = EntityUtil.create();
        entityManager.getTransaction().begin();
        entityManager.merge(city);
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("Данные города ID" + city.getCityId() + " обновлены");

    }

    public void deleteCity(City city) {
        EntityManager entityManager = EntityUtil.create();
        entityManager.getTransaction().begin();
        City city1 = entityManager.find(City.class, city.getCityId());
        entityManager.remove(entityManager.merge(city));
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("Город " + city.getName() + " удален");
    }

    @Override
    public City getCityById(int id) {
        EntityManager entityManager = EntityUtil.create();
        entityManager.getTransaction().begin();
        City city = entityManager.find(City.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return city;
    }

}
