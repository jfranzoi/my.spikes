package my;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.StringWriter;
import java.util.Arrays;

import org.junit.Test;


public class DisplayProgramIntegrationTest {

	@Test
	public void canDisplayDigits() throws Exception {
		StringWriter out = new StringWriter();
		new DisplayProgram(out).execute(new CommandLineParameters(Arrays.asList(1, 2), 2));
		
		String space = " ";
		String twoDigitsJoined = StringHelper.joinWithNewLine(
				"    " + space + " -- ",
				"   |" + space + "   |",
				"   |" + space + "   |",
				"    " + space + " -- ",
				"   |" + space + "|   ",
				"   |" + space + "|   ",
				"    " + space + " -- "
		);
		
		assertEquals(twoDigitsJoined, out.toString());
	}
	
	@Test
	public void canStartAsJavaMainApplication() throws Exception {
		try {
			DisplayProgram.main("-s", "1", "1234567890");
		} catch (Exception e) {
			fail("no exception expected. " +  e);
		}
	}
}
