package fr.epita.advjava;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import fr.epita.advjava.datamodel.Member;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class MemberDAO {

    @PersistenceContext
    private EntityManager entityManager;

    private final DataSource source;

    public MemberDAO(DataSource source){
        this.source = source;
    }



    public List<Member> getAllMembers() {
        return entityManager.createQuery("FROM Member", Member.class).getResultList();
    }
}