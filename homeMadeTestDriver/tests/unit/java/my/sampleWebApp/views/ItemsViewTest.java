package my.sampleWebApp.views;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import my.sampleWebApp.Attributes;
import my.sampleWebApp.BaseTestForTemplate;
import my.sampleWebApp.domain.Item;

import org.junit.Test;

import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTable;

public class ItemsViewTest extends BaseTestForTemplate {

   @Test
   public void shouldShowEmptyTableWhenNoItemsFound() throws Exception {
      String htmlPage = processTemplate("items.ftl", Attributes.with("items", Collections.EMPTY_LIST));
      assertContains(htmlPage, "<table id=\"items\">");
   }

   @Test
   public void shouldShowitemsTable() throws Exception {
      List<Item> items = Arrays.asList(new Item("foo", 1000));
      String htmlPage = processTemplate("items.ftl", Attributes.with("items", items));

      assertContains(htmlPage, "<td>foo</td>");
      assertContains(htmlPage, "<td>1000 &euro;</td>");
   }

   @Test
   public void shouldParsePageContent() throws Exception {
      List<Item> items = Arrays.asList(new Item("foo", 1000));
      String htmlContent = processTemplate("items.ftl", Attributes.with("items", items));

      HtmlPage htmlPage = asPage(htmlContent);
      HtmlTable table = (HtmlTable) htmlPage.getElementById("items");

      assertEquals("foo", table.getCellAt(1, 0).asText());
      assertEquals("1000 \u20AC", table.getCellAt(1, 1).asText());
   }

   @Test
   public void shouldLocalizeLabels() throws Exception {
      setMessage("item.list.heading", "Item List");
      setMessage("item.list.description", "description");
      setMessage("item.list.price", "price");

      String htmlPage = processTemplate("items.ftl", Attributes.with("items", Collections.EMPTY_LIST));

      assertContains(htmlPage, "Item List");
      assertContains(htmlPage, "<td>description</td>");
      assertContains(htmlPage, "<td>price</td>");
   }

}
