package fr.epita.advjava;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import fr.epita.advjava.datamodel.Facility;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class FacilityDAO {
    @PersistenceContext
    private EntityManager entityManager;


    private final DataSource source;

    public FacilityDAO(DataSource source){
        this.source = source;
    }

    public List<Facility> getAllFacilities() {
        return entityManager.createQuery("FROM Facility ", Facility.class).getResultList();
    }


}
