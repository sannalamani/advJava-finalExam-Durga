import fr.epita.advjava.datamodel.Booking;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SpringConfig.class)
public class TestJPA3 {

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void testFetchBookings() {
        List<Booking> bookings = entityManager.createQuery("FROM Booking", Booking.class).getResultList();
        int expectedSize = 4044;
        Assertions.assertEquals(expectedSize, bookings.size());
    }
}
