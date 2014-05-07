package cz.cvut.ds.student17.model;


import javax.persistence.*;
import java.util.Collection;
import cz.cvut.ds.student17.entities.*;

/**
 * Created by jonasamrich on 30/04/14.
 */
public class ExperimentsFacade {

    protected EntityManagerFactory emf = Persistence.createEntityManagerFactory("LabISKrizik");

    protected EntityManager entityManager = emf.createEntityManager();

    public void addTestCustomer(){
        entityManager.getTransaction().begin();
        CustomerEntity ce = new CustomerEntity();

        //ce.setIdCust(112);

        ce.setPhone("800120120");
        ce.setEmail("honza.novak@test.cz");
        ce.setName("Honza Novak");
        entityManager.persist(ce);
        //entityManager.persist(ce); //em.merge(u); for updates
        entityManager.getTransaction().commit();
        entityManager.close();


    }

}
