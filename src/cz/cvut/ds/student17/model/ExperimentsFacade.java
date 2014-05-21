package cz.cvut.ds.student17.model;


import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import cz.cvut.ds.student17.entities.*;
import cz.cvut.ds.student17.exceptions.DatabaseException;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.annotations.SourceType;

/**
 * Created by jonasamrich on 30/04/14.
 */
public class ExperimentsFacade {

    protected EntityManagerFactory emf = Persistence.createEntityManagerFactory("LabISKrizik");
    public void addTestCustomer(){
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        CustomerEntity ce = new CustomerEntity();

        //ce.setIdCust(112);

        ce.setPhone("800120120");
        ce.setEmail("honza.novak@test.cz");
        ce.setFirstName("Honza");
        ce.setLastName("Novák");
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
        EntityManager entityManager = emf.createEntityManager();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = cb.createQuery(entity);
        Root<T> sm = query.from(entity);
        query.where(cb.equal(sm.get(field), value));
        List<T> results = entityManager.createQuery(query).getResultList();
        entityManager.close();
        return results.isEmpty();
    }

    public boolean containsFeature(String title){
        EntityManager entityManager = emf.createEntityManager();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<FeatureEntity> query = cb.createQuery(FeatureEntity.class);
        Root<FeatureEntity> sm = query.from(FeatureEntity.class);
        query.where(cb.equal(sm.get("title"), title));
        List<FeatureEntity> results = entityManager.createQuery(query).getResultList();
        entityManager.close();
        return results.isEmpty();
    }

    public boolean containsDeviceFeaturePair(int idDev, int idFeat){
        EntityManager entityManager = emf.createEntityManager();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<DeviceFeatureEntity> query = cb.createQuery(DeviceFeatureEntity.class);
        Root<DeviceFeatureEntity> sm = query.from(DeviceFeatureEntity.class);
        query.select(sm);
        ParameterExpression<Integer> dev = cb.parameter(Integer.class);
        ParameterExpression<Integer> feat = cb.parameter(Integer.class);
        query.where(cb.equal(sm.get("idDev"), dev),cb.equal(sm.get("idFeat"), feat));
        TypedQuery<DeviceFeatureEntity> tq = entityManager.createQuery(query);
        tq.setParameter(dev, idDev);
        tq.setParameter(feat, idFeat);
        List<DeviceFeatureEntity> results = tq.getResultList();
        entityManager.close();
        return !results.isEmpty();
    }

    public <T> List<T> getAvailableEntities(Class entity){
        EntityManager entityManager = emf.createEntityManager();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = cb.createQuery(entity);
        Root<T> sm = query.from(entity);
        List<T> results = entityManager.createQuery(query).getResultList();
        entityManager.close();
        return results;
    }

    public <T> List<T> getEntitiesById(Class entity, int id, String column) throws Exception {
        EntityManager entityManager = emf.createEntityManager();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = cb.createQuery(entity);
        ParameterExpression<Integer> p = cb.parameter(Integer.class);
        Root<T> sm = query.from(entity);
        query.select(sm).where(cb.equal(sm.get(column), p));
        TypedQuery<T> tq = entityManager.createQuery(query);
        tq.setParameter(p, id);
        List<T> results = tq.getResultList();
        entityManager.close();

        return results;
    }
/*
    public List<CustomerEntity> getEntitiesByIdHaving(int id, String column) throws Exception {
        EntityManager entityManager = emf.createEntityManager();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<CustomerEntity> query = cb.createQuery(CustomerEntity.class);
        ParameterExpression<Integer> p = cb.parameter(Integer.class);
        Root<CustomerEntity> sm = query.from(CustomerEntity.class);
        query.select(sm.get("idCust"),cb.count(sm.get("idCust")));
        query.groupBy(sm.get("idCust"),sm.get("statusCode"));
        query.having(cb.equal(sm.get("statusCode"),"OK"));
        TypedQuery<CustomerEntity> tq = entityManager.createQuery(query);
        tq.setParameter(p, id);
        List<T> results = tq.getResultList();
        entityManager.close();

        return results;
    }*/

    public <T> T getFirstEntityById(Class entity, int id, String column) throws Exception {
        List<T> results = getEntitiesById(entity,id,column);
        if(results.isEmpty()){
            System.out.println("zaznam nenalezen");
            throw new Exception();

        }
        return results.get(0);
    }

    public <T> T getFirstEntityByTextId(Class entity, String id, String column) throws Exception {
        EntityManager entityManager = emf.createEntityManager();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = cb.createQuery(entity);
        ParameterExpression<String> p = cb.parameter(String.class);
        Root<T> sm = query.from(entity);
        query.select(sm).where(cb.equal(sm.get(column), p));
        TypedQuery<T> tq = entityManager.createQuery(query);
        tq.setParameter(p, id);
        List<T> results = tq.getResultList();
        entityManager.close();
        if(results.isEmpty()){
            System.out.println("zaznam nenalezen");
            throw new Exception();

        }
        return results.get(0);

    }

    public void addNewTrial(String animalStr, String colorStr, String nameStr) throws Exception {
        EntityManager entityManager = emf.createEntityManager();
        Session session = (Session) entityManager.getDelegate();
        session.setFlushMode(FlushMode.MANUAL);
        entityManager.getTransaction().begin();
        TrialEntity te = new TrialEntity();
        te.setIdExp(2);
        te.setCost(10);
        te.setIdVic(10);
        entityManager.persist(te);
        System.out.println(te.getIdTrial());
        ResultsEntity animal = new ResultsEntity();
        animal.setIdFs(2);
        animal.setIdTrial(te.getIdTrial());
        animal.setResValue(animalStr);
        ResultsEntity color = new ResultsEntity();
        color.setIdFs(1);
        color.setIdTrial(te.getIdTrial());
        color.setResValue(colorStr);
        ResultsEntity name = new ResultsEntity();
        name.setIdFs(3);
        name.setIdTrial(te.getIdTrial());
        name.setResValue(nameStr);
        entityManager.persist(animal);
        entityManager.persist(color);
        entityManager.persist(name);
        session.flush();

        entityManager.getTransaction().commit();
        entityManager.clear();
        session.close();
        System.out.println("Uoženo");
    }

    public void addCustomer(String firstName, String lastName, String phone, String email) throws DatabaseException{
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        CustomerEntity ce = new CustomerEntity();
         ce.setPhone(phone);
        ce.setEmail(email);
        ce.setFirstName(firstName);
        ce.setLastName(lastName);
        try{
            entityManager.persist(ce);
            entityManager.getTransaction().commit();
        }catch(RollbackException e){
            entityManager.getTransaction().rollback(); //is it necessary to rollback if it is a Rollback exception?
            System.out.println("Database failed.");
            throw new DatabaseException();
        }

        entityManager.close();
    }
    public void updateCustomer(CustomerEntity ce) throws DatabaseException {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        try{
            entityManager.merge(ce);
            entityManager.getTransaction().commit();
        }catch(RollbackException e){
            entityManager.getTransaction().rollback(); //is it necessary to rollback if it is a Rollback exception?
            System.out.println("Database failed.");
            throw new DatabaseException();
        }

        entityManager.close();
    }
    public void removeCustomer(CustomerEntity ce) throws DatabaseException {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        try{
            entityManager.remove(entityManager.contains(ce) ? ce : entityManager.merge(ce));
            System.out.println("Objekt "+ce.getLastName() + "odstranen.");
            entityManager.getTransaction().commit();
        }catch(RollbackException e){
            entityManager.getTransaction().rollback(); //is it necessary to rollback if it is a Rollback exception?
            System.out.println("Database failed.");
            throw new DatabaseException();
        }

        entityManager.close();
    }
    public void addDevice(String title, String description, List<Integer> featuresIds) throws DatabaseException{
        EntityManager entityManager = emf.createEntityManager();
        DeviceEntity de = new DeviceEntity();
        de.setTitle(title);
        de.setDescription(description);
        System.out.println("Pridavam zarizeni:");

        try{
            entityManager.getTransaction().begin();
            entityManager.persist(de);
            for(Integer id : featuresIds){
                DeviceFeatureEntity dfe = new DeviceFeatureEntity();
                dfe.setIdDev(de.getIdDev());
                dfe.setIdFeat(id);
                entityManager.persist(dfe);
            }
            entityManager.getTransaction().commit();
        }catch(RuntimeException e){
            System.out.println("Database failed.");
            e.printStackTrace();
            throw new DatabaseException();
        }

        entityManager.close();
    }
    public void updateDevice(DeviceEntity de,List<Integer> featuresIds) throws DatabaseException {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        try{
            entityManager.merge(de);
            List<DeviceFeatureEntity> lfe = getEntitiesById(DeviceFeatureEntity.class, de.getIdDev(), "idDev");
            for(DeviceFeatureEntity ent : lfe){
                if(featuresIds.contains(ent)){
                    featuresIds.remove(ent);
                }else{
                    entityManager.remove(entityManager.contains(ent) ? ent : entityManager.merge(ent));
                }
            }
            for(Integer id : featuresIds){
                DeviceFeatureEntity dfe = new DeviceFeatureEntity();
                dfe.setIdDev(de.getIdDev());
                dfe.setIdFeat(id);
                entityManager.persist(dfe);
            }
            entityManager.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback(); //is it necessary to rollback if it is a Rollback exception?
            System.out.println("Database failed.");
            throw new DatabaseException();
        }

        entityManager.close();

    }
    public void removeDevice(DeviceEntity de) throws DatabaseException {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        try{
            entityManager.remove(entityManager.contains(de) ? de : entityManager.merge(de));
            System.out.println("Objekt "+de.getTitle() + "odstranen.");
            entityManager.getTransaction().commit();
        }catch(RollbackException e){
            System.out.println("Database failed. Maybe this device is in a trial");
            throw new DatabaseException();
        }

        entityManager.close();
    }

    public void addFeature(String title) throws DatabaseException{
        EntityManager entityManager = emf.createEntityManager();
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

        entityManager.close();
    }
    public void addVictim(String firstName, String lastName, String phone, String email, Timestamp birthdate) throws DatabaseException{
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        VictimEntity ve = new VictimEntity();
        ve.setPhone(phone);
        ve.setEmail(email);
        ve.setFirstName(firstName);
        ve.setLastName(lastName);
        ve.setBirthDate(birthdate);
        try{
            entityManager.persist(ve);
            entityManager.getTransaction().commit();
        }catch(RollbackException e){
            entityManager.getTransaction().rollback(); //is it necessary to rollback if it is a Rollback exception?
            System.out.println("Database failed.");
            throw new DatabaseException();
        }

        entityManager.close();
    }

    public void addExperiment(String title, String description, int budget, String status,List<Integer> featuresIds) throws DatabaseException{
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        ExperimentEntity ee = new ExperimentEntity();
        ee.setTitle(title);
        ee.setDescription(description);
        ee.setBudget(budget);
        ee.setStatusCode(status);
        try{
            entityManager.persist(ee);
            entityManager.getTransaction().commit();
        }catch(RollbackException e){
            entityManager.getTransaction().rollback(); //is it necessary to rollback if it is a Rollback exception?
            System.out.println("Database failed.");
            throw new DatabaseException();
        }

        entityManager.close();
    }
    public void updateExperiment(ExperimentEntity ee) throws DatabaseException {
            EntityManager entityManager = emf.createEntityManager();
            entityManager.getTransaction().begin();
            try{
                entityManager.merge(ee);
                entityManager.getTransaction().commit();
            }catch(RollbackException e){
                entityManager.getTransaction().rollback(); //is it necessary to rollback if it is a Rollback exception?
                System.out.println("Database failed.");
                throw new DatabaseException();
            }

            entityManager.close();
    }
    public void removeExperiment(ExperimentEntity ee) throws DatabaseException {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        try{
            entityManager.remove(entityManager.contains(ee) ? ee : entityManager.merge(ee));
            System.out.println("Objekt "+ee.getTitle() + "odstranen.");
            entityManager.getTransaction().commit();
        }catch(RollbackException e){
            entityManager.getTransaction().rollback(); //is it necessary to rollback if it is a Rollback exception?
            System.out.println("Database failed.");
            throw new DatabaseException();
        }

        entityManager.close();
    }
    public void addTestSet(){
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        CustomerEntity ce = new CustomerEntity();

        //ce.setIdCust(112);

        ce.setPhone("800140140");
        ce.setEmail("mrkev.zelnickak@test.cz");
        //ce.setName("Mrkev Zelnička");
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

        //FormtypEntity fte = new FormtypEntity();
        //fte.setName("Jednoduchý formulář s jedním políčkem");
        //entityManager.persist(fte);

        ExperimentEntity ee = new ExperimentEntity();
        ee.setTitle("Testování úsměvu před kamerou");
        //ee.setIdCust(ce.getIdCust());
        ee.setBudget(350);
        ee.setDescription("Cílem experimentu je zjistit, jak se lidé chvoají před kamerou.");
        //ee.setIdFt(fte.getIdFt());

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
