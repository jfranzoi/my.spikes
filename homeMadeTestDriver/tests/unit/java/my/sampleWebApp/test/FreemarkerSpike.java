package my.sampleWebApp.test;

import java.io.File;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

public class FreemarkerSpike {

   @SuppressWarnings("unchecked")
   public static void main(String[] args) throws Exception {

      Configuration cfg = new Configuration();
      cfg.setDirectoryForTemplateLoading(new File("tests/views"));
      cfg.setObjectWrapper(new DefaultObjectWrapper());

      Template temp = cfg.getTemplate("test.ftl");

      Map root = new HashMap();
      root.put("user", "Big Joe");
      Map latest = new HashMap();
      root.put("latestProduct", latest);
      latest.put("url", "products/greenmouse.html");
      latest.put("name", "green mouse");

      Writer out = new OutputStreamWriter(System.out);
      temp.process(root, out);
      out.flush();

   }

}
