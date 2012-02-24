package my.sampleWebApp.brokers;

import static my.IntegrationTestHelper.execute;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import my.IntegrationTestForDataAccess;
import my.sampleWebApp.domain.Item;

import org.junit.Before;
import org.junit.Test;

public class ItemBrokerIntegrationTest extends IntegrationTestForDataAccess {

   @Before
   public void deleteAllItems() throws Exception {
      execute("DELETE FROM items", dataSource);
   }

   @Test
   public void shouldGetItemOnEmptyData() throws Exception {
      List<Item> noResult = new ArrayList<Item>();
      assertEquals(noResult, new DbItemBroker(dataSource).all());
   }

   @Test
   public void shouldGetItems() throws Exception {
      execute("INSERT INTO items (description, price) VALUES ('PC', 1500)", dataSource);

      assertEquals(Arrays.asList(new Item("PC", 1500)), new DbItemBroker(dataSource).all());
   }
}
