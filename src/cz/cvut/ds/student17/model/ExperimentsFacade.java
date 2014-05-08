package cz.cvut.ds.student17.model;


import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Collection;
import java.util.List;

import cz.cvut.ds.student17.entities.*;
import org.hibernate.annotations.SourceType;

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
    public boolean containsFeature(String title){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<FeatureEntity> query = cb.createQuery(FeatureEntity.class);
        Root<FeatureEntity> sm = query.from(FeatureEntity.class);
        query.where(cb.equal(sm.get("title"), title));
        List<FeatureEntity> results = entityManager.createQuery(query).getResultList();

        return results.isEmpty();
    }
    public void addTestSet(){
        entityManager.getTransaction().begin();
        CustomerEntity ce = new CustomerEntity();

        //ce.setIdCust(112);

        ce.setPhone("800140140");
        ce.setEmail("mrkev.zelnickak@test.cz");
        ce.setName("Mrkev Zelnička");
        entityManager.persist(ce);

        System.out.println("should be false:");
        System.out.println(containsFeature("Kamera  2"));
        System.out.println("should be true");
        System.out.println(containsFeature("Kamera 3"));
        FeatureEntity fe = new FeatureEntity();
        fe.setTitle("Kamera  2");
        entityManager.persist(fe);

        FormtypEntity fte = new FormtypEntity();
        fte.setName("Jednoduchý formulář s jedním políčkem");
        entityManager.persist(fte);

        ExperimentEntity ee = new ExperimentEntity();
        ee.setTitle("Testování úsměvu před kamerou");
        ee.setIdCust(ce.getIdCust());
        ee.setBudget(350);
        ee.setDescription("Cílem experimentu je zjistit, jak se lidé chvoají před kamerou.");
        ee.setIdFt(fte.getIdFt());

        //entityManager.persist(ce); //em.merge(u); for updates
        try {
            entityManager.persist(ee);
            entityManager.getTransaction().commit();
        }catch(RollbackException e){
            System.out.println("Database failed.");
        }

        entityManager.close();
    }

}
