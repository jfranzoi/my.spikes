package my;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class DisplayProgram {
	
	public static void main(Writer output, String... commandLineArguments) throws IOException {
		try {
			CommandLineParameters parameters = CommandLine.parse(commandLineArguments);
			if(parameters.areValid()) {
				new DisplayProgram(output).execute(parameters);
			} else {
				output.write("usage: [-s size] numbers");
			}
		} catch (Exception e) {
			output.write(e.getMessage());
		}
	}

	public static void main(String... args) throws IOException {
		OutputStreamWriter output = new OutputStreamWriter(System.out);
		
		main(output, args);
		
		output.write(StringHelper.newline);
		output.flush();
	}

	private final Writer writer;

	public DisplayProgram(Writer writer) {
		this.writer = writer;
	}

	public void execute(CommandLineParameters parameters) throws IOException {
		new Display(writer).diplay_ResizedTo(parameters.values(), parameters.size());
	}

}
