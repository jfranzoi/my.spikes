package my.sampleWebApp.cotrollers;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import my.sampleWebApp.domain.Item;

import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.ExtendedModelMap;

public class ItemsControllerTest {

   private ExtendedModelMap model;

   @Before
   public void setUp() {
      model = new ExtendedModelMap();
   }

   @Test
   public void shouldShowItemsView() throws Exception {
      assertEquals("items", new ItemsController(new StubItemBroker()).all(model));
   }

   @Test
   public void shouldPopulateItemList() throws Exception {
      final List<Item> items = Arrays.asList(new Item("foo", 50));
      new ItemsController(new StubItemBroker(items)).all(model);

      assertEquals(items, model.get("items"));
   }
}
