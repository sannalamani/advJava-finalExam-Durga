import fr.epita.advjava.datamodel.Facility;
import fr.epita.advjava.datamodel.Member;
import org.junit.jupiter.api.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class TestJUN2 {
    private static final String DB_URL = "jdbc:h2:mem:default";
    private static final String DB_USERNAME = "sa";
    private static final String DB_PASSWORD = "sa";
    private Connection connection;

    @BeforeEach
    public void setup() {
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @AfterEach
    public void cleanup() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFetchMembers() throws SQLException {

        connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        executeSqlScript(connection,"src/test/resources/create-members.sql");
        executeSqlScript(connection,"src/test/resources/insert-members.sql");

        List<Member> members = readMembers(connection);
        int expectedSize = 30; // Set the expected size of the member list

        Assertions.assertEquals(expectedSize, members.size());
    }

    private static void executeSqlScript(Connection connection, String fileName) throws SQLException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName));
             Statement statement = connection.createStatement()) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line.trim());
                if (line.endsWith(";")) {
                    String sql = sb.toString();
                    statement.execute(sql.substring(0, sql.length() - 1)); // Remove the trailing semicolon
                    sb.setLength(0);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<Member> readMembers(Connection connection) throws SQLException {
        List<Member> members = new ArrayList<>();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM members"); {
            while (resultSet.next()) {
                Member member = new Member();
                member.setMemId(resultSet.getInt("memid"));
                member.setSurname(resultSet.getString("surname"));
                member.setFirstName(resultSet.getString("firstname"));
                member.setAddress(resultSet.getString("address"));
                member.setZipcode(resultSet.getInt("zipcode"));
                member.setTelephone(resultSet.getString("telephone"));
                member.setRecommendedBy(resultSet.getInt("recommendedby"));
                member.setJoinDate(resultSet.getTimestamp("joindate"));
                members.add(member);
            }
        }
        return members;
    }

}









