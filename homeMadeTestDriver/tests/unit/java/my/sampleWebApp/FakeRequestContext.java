package my.sampleWebApp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.support.RequestContext;

public class FakeRequestContext extends RequestContext {

   private static final String emptyString = "";
   private final Map<String, String> messages = new HashMap<String, String>();

   public void setMessage(String code, String value) {
      messages.put(code, value);
   }

   @Override
   public String getMessage(String code, String defaultMessage) {
      return lookupMessage(code, defaultMessage);
   }

   @Override
   public String getMessage(String code) throws NoSuchMessageException {
      return lookupMessage(code, emptyString);
   }

   @Override
   public String getMessage(MessageSourceResolvable resolvable, boolean htmlEscape) throws NoSuchMessageException {
      return emptyString;
   }

   @Override
   public String getMessage(MessageSourceResolvable resolvable) throws NoSuchMessageException {
      return emptyString;
   }

   @SuppressWarnings("unchecked")
   @Override
   public String getMessage(String code, List args) throws NoSuchMessageException {
      return emptyString;
   }

   @Override
   public String getMessage(String code, Object[] args, boolean htmlEscape) throws NoSuchMessageException {
      return emptyString;
   }

   @Override
   public String getMessage(String code, Object[] args, String defaultMessage, boolean htmlEscape) {
      return defaultMessage;
   }

   @Override
   public String getMessage(String code, Object[] args, String defaultMessage) {
      return defaultMessage;
   }

   @Override
   public String getMessage(String code, Object[] args) throws NoSuchMessageException {
      return emptyString;
   }

   @SuppressWarnings("unchecked")
   @Override
   public String getMessage(String code, List args, String defaultMessage) {
      return lookupMessage(code, defaultMessage);
   }

   @Override
   public String getContextPath() {
      return emptyString;
   }

   @Override
   public String getQueryString() {
      return emptyString;
   }

   @Override
   public String getRequestUri() {
      return emptyString;
   }

   @Override
   public Errors getErrors(String name, boolean htmlEscape) {
      return null;
   }

   @Override
   public Errors getErrors(String name) {
      throw new RuntimeException("Using a fake object!");
   }

   private String lookupMessage(String code, String defaultValue) {
      if (messages.keySet().contains(code)) {
         return messages.get(code);
      }
      return defaultValue;
   }

}
