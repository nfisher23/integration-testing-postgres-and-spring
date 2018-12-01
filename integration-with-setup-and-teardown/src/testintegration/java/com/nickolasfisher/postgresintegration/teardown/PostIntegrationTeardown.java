import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;

@ComponentScan("com.nickolasfisher.postgresintegration")
public class PostIntegrationTeardown {

    public static void main(String args[]) {
        ConfigurableApplicationContext ctx = SpringApplication.run(PostIntegrationTeardown.class, args);

        try {

            destroyTmpTable(ctx);
        } catch (Exception e) {
            System.out.println("you blew up in your teardown code: " + e.toString());
        }

        ctx.registerShutdownHook();
        ctx.close();
    }

    private static void destroyTmpTable(ApplicationContext ctx) {
        JdbcTemplate jdbcTemplate = ctx.getBean(JdbcTemplate.class);

        jdbcTemplate.update("DROP TABLE TMP_TABLE");
    }
}
