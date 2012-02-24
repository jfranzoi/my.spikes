package my;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;


public class CommandLineTest {
	private final static List<Integer> twelve = Arrays.asList(1, 2);
	
	@Test
	public void shouldParseDigitParameterAndUseDefaultSizeOfTwo() throws Exception {
		assertEquals(new CommandLineParameters(twelve, 2), CommandLine.parse("12"));
	}

	@Test
	public void shouldParseSize() throws Exception {
		assertEquals(new CommandLineParameters(twelve, 5), CommandLine.parse("-s", "5", "12"));
	}
	
	@Test
	public void shouldValidateCommandLineArguments() throws Exception {
		assertFalse(CommandLine.parse("-s").areValid());
	}
	
	@Test
	public void shouldValidateCommandLineArguments_NoArgumentsAtAll() throws Exception {
		assertFalse(CommandLine.parse().areValid());
	}
}
