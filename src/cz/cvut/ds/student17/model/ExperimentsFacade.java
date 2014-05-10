package cz.cvut.ds.student17.model;


import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import cz.cvut.ds.student17.entities.*;
import cz.cvut.ds.student17.exceptions.DatabaseException;
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

    /**
     * Returns boolean whether the value would be unique in the field for the entity.
     * @param entity
     * @param field
     * @param value
     * @param <T>
     * @return
     */
    public <T> boolean isUnique(Class<T> entity, String field, String value){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = cb.createQuery(entity);
        Root<T> sm = query.from(entity);
        query.where(cb.equal(sm.get(field), value));
        List<T> results = entityManager.createQuery(query).getResultList();
        return results.isEmpty();
    }

    public boolean containsFeature(String title){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<FeatureEntity> query = cb.createQuery(FeatureEntity.class);
        Root<FeatureEntity> sm = query.from(FeatureEntity.class);
        query.where(cb.equal(sm.get("title"), title));
        List<FeatureEntity> results = entityManager.createQuery(query).getResultList();
        return results.isEmpty();
    }

    public <T> List<T> getAvailableEntities(Class entity){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = cb.createQuery(entity);
        Root<T> sm = query.from(entity);
        List<T> results = entityManager.createQuery(query).getResultList();
        return results;
    }

    public void addCustomer(String name, String phone, String email) throws DatabaseException{
        entityManager.getTransaction().begin();
        CustomerEntity ce = new CustomerEntity();
         ce.setPhone(phone);
        ce.setEmail(email);
        ce.setName(name);
        try{
            entityManager.persist(ce);
            entityManager.getTransaction().commit();
        }catch(RollbackException e){
            entityManager.getTransaction().rollback(); //is it necessary to rollback if it is a Rollback exception?
            System.out.println("Database failed.");
            throw new DatabaseException();
        }

        //entityManager.close();
    }
    public void addFeature(String title) throws DatabaseException{
        entityManager.getTransaction().begin();
        FeatureEntity fe = new FeatureEntity();
        fe.setTitle(title);
        try{
            entityManager.persist(fe);
            entityManager.getTransaction().commit();
        }catch(RollbackException e){
            entityManager.getTransaction().rollback(); //is it necessary to rollback if it is a Rollback exception?
            System.out.println("Database failed.");
            throw new DatabaseException();
        }

        //entityManager.close();
    }
    public void addVictim(String name, String phone, String email, Timestamp birthdate) throws DatabaseException{
        entityManager.getTransaction().begin();
        VictimEntity ve = new VictimEntity();
        ve.setPhone(phone);
        ve.setEmail(email);
        ve.setName(name);
        ve.setBirthDate(birthdate);
        try{
            entityManager.persist(ve);
            entityManager.getTransaction().commit();
        }catch(RollbackException e){
            entityManager.getTransaction().rollback(); //is it necessary to rollback if it is a Rollback exception?
            System.out.println("Database failed.");
            throw new DatabaseException();
        }

        //entityManager.close();
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
        System.out.println(isUnique(FeatureEntity.class, "title","Kamera  2"));
        System.out.println("should be true");
        System.out.println(containsFeature("Kamera 3"));
        System.out.println(isUnique(FeatureEntity.class, "title","Kamera 3"));
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
