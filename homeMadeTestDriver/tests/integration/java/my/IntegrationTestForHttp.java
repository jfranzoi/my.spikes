package my;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.servlet.http.HttpServletResponse;

import org.junit.BeforeClass;
import org.xml.sax.SAXException;

import com.meterware.httpunit.WebResponse;

public abstract class IntegrationTestForHttp {

   private static HttpFacility httpFacility = createHttpFacility();

   @BeforeClass
   public static void testSetUp() throws Exception {
      if (webappAlreadyInitialized()) {
         return;
      }

      httpFacility.initialize(new File("main/web").getAbsolutePath());
   }

   protected WebResponse getResponse(final String anUrl) throws MalformedURLException, IOException, SAXException {
      return httpFacility.getResponse(anUrl);
   }

   private static HttpFacility createHttpFacility() {
      return new JettySixServerAdapter();
   }

   protected static boolean webappAlreadyInitialized() {
      return httpFacility.alreadyInitialized();
   }

   protected void assertIsOk(WebResponse response) {
      assertEquals("Should have response code 200", HttpServletResponse.SC_OK, response.getResponseCode());
   }

   protected String assert_RedirectsTo(WebResponse response, String expectedRedirectionUrl) {
      assertIsRedirection(response);

      String redirectionUrl = response.getHeaderField("Location");
      assertTrue("cannot find " + expectedRedirectionUrl + " in " + redirectionUrl, redirectionUrl.endsWith(expectedRedirectionUrl));

      return redirectionUrl;
   }

   protected void assertIsRedirection(WebResponse response) {
      assertEquals(HttpServletResponse.SC_MOVED_TEMPORARILY, response.getResponseCode());
   }

}