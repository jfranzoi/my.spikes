package my;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class DisplayTest {

	@Test
	public void shouldDisplayMoreDigitsWithSpace() throws Exception {
		List<String> xx = Arrays.asList("x1", "x2");
		List<String> yy = Arrays.asList("y1", "y2");
		
		AsciiPicture composed = new Display(null).compose(Arrays.asList(new AsciiPicture(xx), new AsciiPicture(yy)));
		assertEquals(new AsciiPicture(Arrays.asList("x1 y1", "x2 y2")), composed);
	}
}
