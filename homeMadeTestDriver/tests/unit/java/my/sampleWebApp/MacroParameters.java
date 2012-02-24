package my.sampleWebApp;

public class MacroParameters {

   public static MacroParameters from(Object[] parameters) {
      return new MacroParameters(parameters);
   }

   private final Object[] parameters;

   private MacroParameters(Object[] parameters) {
      this.parameters = parameters;
   }

   public String names() {
      StringBuilder builder = new StringBuilder();

      for (int i = 0; i < parameters.length; i++) {
         String parameterValue = " " + parameterAt(i) + " ";
         builder.append(parameterValue);
      }

      return builder.toString();
   }

   public Attributes asAttributes() {
      Attributes attributes = new Attributes();

      for (int i = 0; i < parameters.length; i++) {
         Object eachParameter = parameters[i];
         attributes.andWith(parameterAt(i), eachParameter);
      }

      return attributes;
   }

   private String parameterAt(int position) {
      return "param" + position;
   }

}