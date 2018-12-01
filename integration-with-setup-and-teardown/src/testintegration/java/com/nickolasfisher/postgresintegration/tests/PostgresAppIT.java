import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static junit.framework.TestCase.assertTrue;

public class PostgresAppIT {

    @Test
    public void simpleIntegrationTest() {
        System.out.println("integration test");
        assertTrue(true);
    }
}
