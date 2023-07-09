
import fr.epita.advjava.FacilityDAO;
import fr.epita.advjava.MemberDAO;
import fr.epita.advjava.datamodel.Facility;
import fr.epita.advjava.datamodel.Member;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SpringConfig.class)
public class TestJPA2 {

    @Autowired
    private MemberDAO memberDAO;

    @Autowired
    private FacilityDAO facilityDAO;

    @Test
    public void testFetchData() {
        // Fetch all members
        List<Member> members = memberDAO.getAllMembers();
        System.out.println("Members:");
        for (Member member : members) {
            System.out.println(member);
        }

        // Fetch all facilities
        List<Facility> facilities = facilityDAO.getAllFacilities();
        System.out.println("Facilities:");

        for (Facility facility : facilities) {
            System.out.println(facility);
        }


    }
}
