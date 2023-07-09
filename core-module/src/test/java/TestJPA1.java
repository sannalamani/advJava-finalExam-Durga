import fr.epita.advjava.datamodel.Member;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.sql.Timestamp;
import java.util.List;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SpringConfig.class)
@Transactional
public class TestJPA1 {

    @Autowired
    private LocalSessionFactoryBean sessionFactoryBean;

    @Test
    public void testPersistMember() {
        SessionFactory sessionFactory = sessionFactoryBean.getObject();
        Session session = sessionFactory.getCurrentSession();

        Member member = new Member();
        member.setMemId(1);
        member.setSurname("Smith");
        member.setFirstName("John");
        member.setAddress("123 Main St");
        member.setZipcode(12345);
        member.setTelephone("555-123-4567");
        member.setRecommendedBy(null); // Assuming no recommendation
        member.setJoinDate(new Timestamp(System.currentTimeMillis()));

        session.persist(member);

            // Assert that the member is correctly persisted
        Member persistedMember = session.find(Member.class, 1);
        Assertions.assertNotNull(persistedMember);
        }



}
