import fr.epita.advjava.BookingRepository;
import fr.epita.advjava.MemberDAO;
import fr.epita.advjava.datamodel.Facility;
import fr.epita.advjava.datamodel.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@SpringBootTest
public class TestJPA4 {

//    @Autowired
//    private BookingRepository bookingRepository;
//
//    @Test
//    @Transactional
//    public void testCreateBooking() {
//        // Fetch member and facility using their respective DAOs or repositories
//        Member member = MemberDAO.findById(memberId).orElse(null);
//        Facility facility = facilityRepository.findById(facilityId).orElse(null);
//
//        if (member != null && facility != null) {
//            LocalDateTime bookingDateTime = LocalDateTime.now();
//            int slotsTaken = 3;
//
//            bookingRepository.createBooking(member, facility, bookingDateTime, slotsTaken);
//
//            // Perform assertions or further operations as needed
//            // ...
//        } else {
//            // Handle the case where member or facility is not found
//        }
//    }
}
