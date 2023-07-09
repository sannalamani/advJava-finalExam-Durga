package fr.epita.advjava;

import fr.epita.advjava.datamodel.Booking;
import fr.epita.advjava.datamodel.Facility;
import fr.epita.advjava.datamodel.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.sql.Timestamp;


@Repository
public class BookingRepository {

    @Autowired
    private EntityManager entityManager;

    public void createBooking(Member member, Facility facility, Timestamp bookingTime, int slots) {
        Booking booking = new Booking();
        booking.setMember(member);
        booking.setFacility(facility);
        booking.setStartTime(bookingTime);
        booking.setSlots(slots);

        entityManager.persist(booking);
    }
}
