import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityUtil {
    public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");

    public static EntityManager create() {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager;
    }

    public static void closeEntityManagerFactory() {

        entityManagerFactory.close();
    }
}