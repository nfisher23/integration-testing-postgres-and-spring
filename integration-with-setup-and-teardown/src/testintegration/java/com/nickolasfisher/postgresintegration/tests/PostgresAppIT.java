import com.nickolasfisher.postgresintegration.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {AppConfig.class})
@ComponentScan(value = "com.nickolasfisher.postgresintegration")
public class PostgresAppIT {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void validateQueryOnRealDB() {
        List<KeyValuePair> pairs = jdbcTemplate.query("SELECT mykey, myvalue FROM TMP_TABLE ORDER BY mykey asc", (rs, rowNum) ->
                new KeyValuePair(rs.getInt(1), rs.getString(2)));

        assertEquals("first", pairs.get(0).getValue());
        assertEquals(1, pairs.get(0).getKey().intValue());

        assertEquals(2, pairs.get(1).getKey().intValue());
        assertEquals("second", pairs.get(1).getValue());
    }

    private class KeyValuePair {

        private Integer key;
        private String value;

        public KeyValuePair(Integer key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public Integer getKey() {
            return key;
        }
    }
}
