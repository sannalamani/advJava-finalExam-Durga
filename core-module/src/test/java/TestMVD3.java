import fr.epita.advjava.datamodel.Facility;
import fr.epita.advjava.datamodel.Member;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestMVD3 {
    private static final String DB_URL = "jdbc:h2:mem:default";
    private static final String DB_USERNAME = "sa";
    private static final String DB_PASSWORD = "sa";

    public static void main(String[] args) {
        try {
            // Create the database connection
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            // Execute the SQL scripts to create and insert data from separate files
            executeSqlScript(connection, "src/test/resources/create-facilities.sql");
            executeSqlScript(connection, "src/test/resources/create-members.sql");
            executeSqlScript(connection, "src/test/resources/insert-facilities.sql");
            executeSqlScript(connection, "src/test/resources/insert-members.sql");

            // Read members from the database
            List<Member> members = readMembers(connection);
            System.out.println("Members:");
            for (Member member : members) {
                System.out.println(member);
            }
            System.out.println();

            // Read facilities from the database
            List<Facility> facilities = readFacilities(connection);
            System.out.println("Facilities:");
            for (Facility facility : facilities) {
                System.out.println(facility);
            }

            // Close the database connection
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

    private static List<Member> readMembers(Connection connection) throws SQLException {
        List<Member> members = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM members")) {
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

    private static List<Facility> readFacilities(Connection connection) throws SQLException {
        List<Facility> facilities = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM facilities")) {
            while (resultSet.next()) {
                Facility facility = new Facility();
                facility.setFacId(resultSet.getInt("facid"));
                facility.setName(resultSet.getString("name"));
                facility.setMemberCost(resultSet.getDouble("membercost"));
                facility.setGuestCost(resultSet.getDouble("guestcost"));
                facility.setInitialOutlay(resultSet.getDouble("initialoutlay"));
                facility.setMonthlyMaintenance(resultSet.getDouble("monthlymaintenance"));
                facilities.add(facility);
            }
        }
        return facilities;
    }
}
