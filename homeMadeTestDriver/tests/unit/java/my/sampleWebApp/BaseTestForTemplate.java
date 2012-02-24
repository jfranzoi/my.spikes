package my.sampleWebApp;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.net.MalformedURLException;

import org.junit.Before;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import freemarker.cache.ClassTemplateLoader;
import freemarker.cache.FileTemplateLoader;
import freemarker.cache.MultiTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

public abstract class BaseTestForTemplate {

   protected static final Attributes emptyAttributes = new Attributes();

   private final FakeRequestContext springMacroRequestContext = new FakeRequestContext();
   private Configuration configuration;

   @Before
   public void setUp() throws Exception {
      configuration = new Configuration();

      FileTemplateLoader fromFilesystem = new FileTemplateLoader(templateRootFolder());
      ClassTemplateLoader fromTestClasspath = new ClassTemplateLoader(FreeMarkerConfig.class, "");
      TemplateLoader[] loaders = new TemplateLoader[] { fromFilesystem, fromTestClasspath };

      configuration.setTemplateLoader(new MultiTemplateLoader(loaders));

      configuration.setObjectWrapper(new DefaultObjectWrapper());
      configuration.setSetting("auto_import", "spring.ftl as spring");
   }

   protected String processTemplate(String templateName, Attributes attributes) throws Exception {
      Template template = configuration.getTemplate(templateName);
      Attributes bound = attributes.andWith("springMacroRequestContext", springMacroRequestContext);

      StringWriter processedResult = new StringWriter();
      template.process(bound, processedResult);

      String result = processedResult.toString();
      processedResult.close();

      return result;
   }

   protected String pathToTemplateRootFolder() {
      return "main/web/WEB-INF/views";
   }

   protected String processTemplate(String templateName) throws Exception {
      return processTemplate(templateName, new Attributes());
   }

   protected String processMacro(String file, String name, Object... parameters) throws Exception {
      MacroParameters macroParameters = MacroParameters.from(parameters);
      String importAndExecuteMacro = "<#import \"%s\" as macros/><@macros.%s %s/>";
      String templateContent = String.format(importAndExecuteMacro, file, name, macroParameters.names());

      File templateFile = createTempFileIn(templateRootFolder(), "templateWithMacros.ftl");
      writeTo(templateFile, templateContent);

      return processTemplate(templateFile.getName(), macroParameters.asAttributes());
   }

   protected void setMessage(String code, String value) {
      springMacroRequestContext.setMessage(code, value);
   }

   protected HtmlPage asPage(String htmlContent) throws IOException, MalformedURLException {
      File systemTempFolder = new File(System.getProperty("java.io.tmpdir"));
      File generatedHtmlFile = createTempFileIn(systemTempFolder, "generated.html");
      writeTo(generatedHtmlFile, htmlContent);

      WebClient client = new WebClient();
      return (HtmlPage) client.getPage("file://" + generatedHtmlFile.getAbsolutePath());
   }

   protected void assertContains(String content, String toFind) {
      assertTrue(cantFind(toFind, content), content.contains(toFind));
   }

   private File templateRootFolder() {
      return new File(pathToTemplateRootFolder());
   }

   private File createTempFileIn(File pathToFolder, String fileName) throws IOException {
      File aFile = new File(pathToFolder, fileName);
      aFile.deleteOnExit();
      aFile.createNewFile();
      assertTrue(aFile.exists());

      return aFile;
   }

   private String cantFind(String toFind, String content) {
      return "cannot find " + toFind + " in " + content;
   }

   private void writeTo(File aFile, String content) throws IOException {
      FileWriter fileWriter = new FileWriter(aFile);
      fileWriter.write(content);
      fileWriter.close();
   }

}