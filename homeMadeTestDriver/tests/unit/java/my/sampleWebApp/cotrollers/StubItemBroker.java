/**
 * 
 */
package my.sampleWebApp.cotrollers;

import java.util.ArrayList;
import java.util.List;

import my.sampleWebApp.brokers.ItemBroker;
import my.sampleWebApp.domain.Item;

public class StubItemBroker implements ItemBroker {
   private final List<Item> items;

   public StubItemBroker(List<Item> items) {
      this.items = items;
   }

   public StubItemBroker() {
      this(new ArrayList<Item>());
   }

   public List<Item> all() throws Exception {
      return items;
   }
}