import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = SpringConfig.class)
public class TestSPR1 {

    @Autowired
    private String testString;

    @Test
    public void testInjectedString() {
        System.out.println(testString);
    }
}