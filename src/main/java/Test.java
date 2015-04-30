import com.softserve.edu.app.model.Address;
import com.softserve.edu.config.root.DevelopmentJPAConfigs;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@EnableAutoConfiguration
@ComponentScan
public class Test {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(DevelopmentJPAConfigs.class);
        EntityManager entityManager = applicationContext.getBean(EntityManagerFactory.class).createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(new Address("aaa", "bbb"));
        entityManager.getTransaction().commit();
        System.out.println(entityManager.find(Address.class, 1L).getStreet());
    }
}
