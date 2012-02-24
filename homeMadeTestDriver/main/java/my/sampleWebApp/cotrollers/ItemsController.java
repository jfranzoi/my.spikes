package my.sampleWebApp.cotrollers;

import my.sampleWebApp.brokers.ItemBroker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ItemsController {

   private final ItemBroker itemBroker;

   @Autowired
   public ItemsController(ItemBroker itemBroker) {
      this.itemBroker = itemBroker;
   }

   @RequestMapping("/items/all*")
   public String all(Model model) throws Exception {
      model.addAttribute("items", itemBroker.all());
      return "items";
   }
}
