package my.sampleWebApp.http;

import static my.IntegrationTestHelper.execute;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import my.IntegrationTestForHttpWithinTransaction;

import org.junit.Before;
import org.junit.Test;

import com.meterware.httpunit.WebResponse;
import com.meterware.httpunit.WebTable;

public class AllItemsIntegrationTest extends IntegrationTestForHttpWithinTransaction {

   @Before
   public void deleteAllItems() throws Exception {
      execute("DELETE FROM items", dataSource);
   }

   @Test
   public void shouldShowEmptyListByDefault() throws Exception {
      WebResponse response = getResponse("/items/all.do");
   
      assertIsOk(response);
      assertTrue(response.getText().contains("Item List"));
   
      WebTable items = response.getTableWithID("items");
   
      assertEquals(1, items.getRowCount());
      assertEquals("description", items.getCellAsText(0, 0));
      assertEquals("price", items.getCellAsText(0, 1));
   }

   @Test
   public void shouldShowItemList() throws Exception {
      execute("INSERT INTO items (description, price) VALUES ('MacBookPro', 2000)", dataSource);
      execute("INSERT INTO items (description, price) VALUES ('PC', 1500)", dataSource);

      WebResponse response = getResponse("/items/all.do");

      WebTable items = response.getTableWithID("items");

      assertEquals(3, items.getRowCount());

      assertEquals("MacBookPro", items.getCellAsText(1, 0));
      assertEquals("2000 \u20AC", items.getCellAsText(1, 1));

      assertEquals("PC", items.getCellAsText(2, 0));
      assertEquals("1500 \u20AC", items.getCellAsText(2, 1));
   }
}
