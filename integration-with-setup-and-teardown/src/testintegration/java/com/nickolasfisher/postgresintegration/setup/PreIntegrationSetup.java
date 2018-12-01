import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;

@ComponentScan("com.nickolasfisher.postgresintegration")
public class PreIntegrationSetup {

    public static void main(String args[]) {
        ConfigurableApplicationContext ctx = SpringApplication.run(PreIntegrationSetup.class, args);
        try {
            createTmpTable(ctx);
            insertTmpData(ctx);
        } catch (Exception e) {
            System.out.println("you blew up in your setup code: " + e.toString());
        }
        ctx.registerShutdownHook();
        ctx.close();
    }

    private static void createTmpTable(ApplicationContext ctx) {
        JdbcTemplate jdbcTemplate = ctx.getBean(JdbcTemplate.class);

        jdbcTemplate.update("CREATE TABLE TMP_TABLE (mykey INTEGER, myvalue text)");
    }

    private static void insertTmpData(ApplicationContext ctx) {
        JdbcTemplate jdbcTemplate = ctx.getBean(JdbcTemplate.class);

        jdbcTemplate.update("INSERT INTO TMP_TABLE (mykey, myvalue) VALUES (1, 'first')");
        jdbcTemplate.update("INSERT INTO TMP_TABLE (mykey, myvalue) VALUES (2, 'second')");
    }
}
