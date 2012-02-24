package my;

import java.io.IOException;
import java.net.MalformedURLException;

import org.xml.sax.SAXException;

import com.meterware.httpunit.WebResponse;

public interface HttpFacility {

   public abstract void initialize(String webappRoot) throws Exception;

   public abstract boolean alreadyInitialized();

   public abstract WebResponse getResponse(final String anUrl) throws MalformedURLException, IOException, SAXException;

}