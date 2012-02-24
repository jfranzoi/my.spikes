package my;

import static org.junit.Assert.assertTrue;

import java.io.StringWriter;

import org.junit.Test;

public class DisplayProgramTest {

	@Test
	public void shouldCatchAnyExceptionAndShowUsage() throws Exception {
		StringWriter output = new StringWriter();
		
		DisplayProgram.main(output);
		assertTrue(output.toString().contains("usage: [-s size] numbers"));
	}
}
