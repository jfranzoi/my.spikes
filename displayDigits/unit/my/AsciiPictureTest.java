package my;

import static org.junit.Assert.assertEquals;

import java.io.StringWriter;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;


public class AsciiPictureTest {

	private AsciiPicture aa;
	private AsciiPicture bb;

	@Before
	public void setUp(){
		aa = new AsciiPicture(Arrays.asList("A", "A"));
		bb = new AsciiPicture(Arrays.asList("B", "B"));
	}
	
	@Test
	public void shouldJoinPicture() throws Exception {
		assertEquals(new AsciiPicture(Arrays.asList("AB", "AB")), aa.join(bb));
	}
	
	@Test
	public void shouldFormatWithNewlines() throws Exception {
		StringWriter output = new StringWriter();
		
		aa.join(bb).appendTo(output);
		assertEquals("AB\nAB", output.toString());
	}
	
	@Test
	public void shouldResizeLine() throws Exception {
		AsciiPicture oneSized = new AsciiPicture(Arrays.asList(" - ", "|  ", " - "));
		assertEquals(new AsciiPicture(Arrays.asList(" -- ", "|   ", "|   ", " -- ")), oneSized.resizedTo(2));
	}
}
