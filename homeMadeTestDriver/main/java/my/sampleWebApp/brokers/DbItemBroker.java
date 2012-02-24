package my.sampleWebApp.brokers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import my.sampleWebApp.domain.Item;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class DbItemBroker implements ItemBroker {

   private JdbcTemplate jdbcTemplate;

   public DbItemBroker(DataSource aDatasource) {
      jdbcTemplate = new JdbcTemplate(aDatasource);
   }

   @SuppressWarnings("unchecked")
   public List<Item> all() throws Exception {
      return jdbcTemplate.query("SELECT * FROM items", new RowMapper() {
         public Object mapRow(ResultSet resultSet, int ignored) throws SQLException {
            return new Item(resultSet.getString("description"), resultSet.getInt("price"));
         }
      });
   }
}
