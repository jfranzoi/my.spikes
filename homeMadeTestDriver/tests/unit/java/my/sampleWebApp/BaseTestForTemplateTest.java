package my.sampleWebApp;

import static org.junit.Assert.assertEquals;
import my.sampleWebApp.test.User;

import org.junit.Test;

import freemarker.core.InvalidReferenceException;

public class BaseTestForTemplateTest extends BaseTestForTemplate {

   @Override
   protected String pathToTemplateRootFolder() {
      return "tests/views";
   }

   @Test
   public void shouldLoadStaticTemplate() throws Exception {
      assertEquals("<div>Hello, world!</div>", processTemplate("hello.ftl", emptyAttributes));
   }

   @Test
   public void shouldPopulateTemplateWithData() throws Exception {
      String htmlResult = processTemplate("loggedIn.ftl", Attributes.with("user", new User("FooBar")));
      assertEquals("logged in as FooBar", htmlResult);
   }

   @Test(expected = InvalidReferenceException.class)
   public void shouldThrowExceptionsOnMissingAttributes() throws Exception {
      processTemplate("loggedIn.ftl", emptyAttributes);
   }

   @Test
   public void shouldUseBooleanOperators() throws Exception {
      String htmlResult = processTemplate("loggedInWithDefault.ftl", Attributes.with("user", new User()));
      assertEquals("logged in as ", htmlResult);
   }

   @Test
   public void shouldProcessMacro() throws Exception {
      assertEquals("Hello, Foo", processMacro("macros.ftl", "helloFoo"));
   }

   @Test
   public void shouldUseMacroWithParameters() throws Exception {
      assertEquals("Hello, Bar", processMacro("macros.ftl", "hello", "Bar"));
   }

   @Test
   public void shouldUseMacroWithDefaultParameterValues() throws Exception {
      assertEquals("Hello, Foo", processMacro("macros.ftl", "hello"));
   }

   @Test
   public void shouldUseParametersAsBoundObjects() throws Exception {
      assertEquals("5.00", processMacro("macros.ftl", "twoDecimalDigits", 5L));
   }

}
