import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;


import javax.sql.DataSource;



@SpringBootTest(classes = SpringConfig.class)
public class TestSPR2 {

    @Autowired
    private DataSource dataSource;

    @Test
    public void testMemberCount() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        int memberCount = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM members", Integer.class);

        // Assert the members count is as expected
        int expectedMemberCount = 30;
        Assertions.assertEquals(expectedMemberCount, memberCount);
    }

}
