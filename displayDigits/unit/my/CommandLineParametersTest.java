package my;

import static org.junit.Assert.assertFalse;

import java.util.ArrayList;

import org.junit.Test;


public class CommandLineParametersTest {

	@Test
	public void shouldValidateMandatoryParameters() throws Exception {
		int anySize = 0;
		ArrayList<Integer> noNumbers = new ArrayList<Integer>();
		
		assertFalse(new CommandLineParameters(noNumbers, anySize).areValid());
	}
}
