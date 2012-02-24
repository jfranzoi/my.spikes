package my.sampleWebApp.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Item {

   private final String description;
   private final int price;

   public Item(String description, int price) {
      this.description = description;
      this.price = price;
   }

   @Override
   public boolean equals(Object anObject) {
      return EqualsBuilder.reflectionEquals(this, anObject);
   }

   @Override
   public int hashCode() {
      return HashCodeBuilder.reflectionHashCode(this);
   }

   @Override
   public String toString() {
      return ToStringBuilder.reflectionToString(this);
   }

   public String getDescription() {
      return description;
   }

   public int getPrice() {
      return price;
   }

}
