package my;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class IntegrationTestHelper {

   public static void execute(String sqlQuery, DataSource aDataSource) throws SQLException {
      new JdbcTemplate(aDataSource).execute(sqlQuery);
   }

}
