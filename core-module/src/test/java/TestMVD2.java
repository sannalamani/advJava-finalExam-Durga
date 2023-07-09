
    import fr.epita.advjava.datamodel.Facility;
    import fr.epita.advjava.datamodel.Member;

    import java.sql.Timestamp;

    public class TestMVD2 {
        public static void main(String[] args) {
            // Create an instance of Facility with hardcoded values
            Facility facility = new Facility();
            facility.setFacId(1);
            facility.setName("Gym");
            facility.setMemberCost(50.0);
            facility.setGuestCost(10.0);
            facility.setInitialOutlay(1000.0);
            facility.setMonthlyMaintenance(100.0);

            System.out.println(facility + "\n");

            // Create an instance of Member with hardcoded values
            Member member = new Member();
            member.setMemId(1);
            member.setSurname("Smith");
            member.setFirstName("John");
            member.setAddress("123 Main St");
            member.setZipcode(12345);
            member.setTelephone("555-1234");
            member.setRecommendedBy(null);
            member.setJoinDate(new Timestamp(System.currentTimeMillis()));

            System.out.println(member);
        }
    }


