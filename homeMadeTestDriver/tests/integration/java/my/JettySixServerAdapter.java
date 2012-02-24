package my;

import java.io.IOException;
import java.net.MalformedURLException;

import org.mortbay.jetty.Server;
import org.mortbay.jetty.webapp.WebAppContext;
import org.xml.sax.SAXException;

import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebResponse;

public class JettySixServerAdapter implements HttpFacility {

   private static final int LOCAL_PORT = 8085;

   private Server server;
   private WebConversation client;

   public boolean alreadyInitialized() {
      return server != null;
   }

   public WebResponse getResponse(String anUrl) throws MalformedURLException, IOException, SAXException {
      return client.getResponse("http://localhost:" + LOCAL_PORT + "/" + anUrl);
   }

   public void initialize(String webappRoot) throws Exception {
      server = new Server(LOCAL_PORT);

      WebAppContext webapp = new WebAppContext();
      webapp.setContextPath("/");
      webapp.setWar(webappRoot);

      server.setHandler(webapp);
      server.setStopAtShutdown(true);

      server.start();

      client = new WebConversation();
   }

}
