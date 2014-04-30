package cz.cvut.ds.student17.model;


import cz.cvut.ds.student17.entities.ExperimentEntity;

import javax.persistence.*;
import javax.persistence.spi.PersistenceProvider;
import java.util.Collection;

/**
 * Created by jonasamrich on 30/04/14.
 */
public class ExperimentsFacade {

    protected EntityManagerFactory emf = Persistence.createEntityManagerFactory("LabISKrizik");

    protected EntityManager entityManager = emf.createEntityManager();

    public int countExperiments() {
        Query q = entityManager.createNamedQuery("countExperiments");
        return (int) q.getFirstResult();
    }

    public Collection<ExperimentEntity> getAllExperiments() {
        Query q = entityManager.createNamedQuery("getAllExperiments");
        return (Collection<ExperimentEntity>) q.getResultList();
    }

}
