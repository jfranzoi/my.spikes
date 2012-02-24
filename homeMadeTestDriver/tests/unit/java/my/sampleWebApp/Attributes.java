package my.sampleWebApp;

import java.util.HashMap;

public class Attributes extends HashMap<String, Object> {
   private static final long serialVersionUID = 1L;

   public static Attributes with(String key, Object value) {
      Attributes attributes = new Attributes();
      attributes.put(key, value);
      return attributes;
   }

   public Attributes andWith(String key, Object value) {
      put(key, value);
      return this;
   }
}
