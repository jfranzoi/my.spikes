package my.sampleWebApp.domain;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ItemTest {

   @Test
   public void equality() throws Exception {
      Item foo = new Item("foo", 10);

      assertTrue(new Item("foo", 10).equals(foo));
      assertFalse(new Item("any", 10).equals(foo));
   }

}
