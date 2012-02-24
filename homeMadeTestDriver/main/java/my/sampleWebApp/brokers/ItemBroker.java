package my.sampleWebApp.brokers;

import java.util.List;

import my.sampleWebApp.domain.Item;

public interface ItemBroker {

   public List<Item> all() throws Exception;

}