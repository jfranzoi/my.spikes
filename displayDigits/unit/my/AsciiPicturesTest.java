package my;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class AsciiPicturesTest {

	@Test
	public void shouldDisplayDigits() throws Exception {
		assertEquals(new AsciiPicture(AsciiPictures.ZERO), AsciiPictures.asPicture(0, 1));
		assertEquals(new AsciiPicture(AsciiPictures.ONE), AsciiPictures.asPicture(1, 1));
		assertEquals(new AsciiPicture(AsciiPictures.TWO), AsciiPictures.asPicture(2, 1));
		assertEquals(new AsciiPicture(AsciiPictures.THREE), AsciiPictures.asPicture(3, 1));
		assertEquals(new AsciiPicture(AsciiPictures.FOUR), AsciiPictures.asPicture(4, 1));
		assertEquals(new AsciiPicture(AsciiPictures.FIVE), AsciiPictures.asPicture(5, 1));
		assertEquals(new AsciiPicture(AsciiPictures.SIX), AsciiPictures.asPicture(6, 1));
		assertEquals(new AsciiPicture(AsciiPictures.SEVEN), AsciiPictures.asPicture(7, 1));
		assertEquals(new AsciiPicture(AsciiPictures.EIGHT), AsciiPictures.asPicture(8, 1));
		assertEquals(new AsciiPicture(AsciiPictures.NINE), AsciiPictures.asPicture(9, 1));
	}
	
	@Test
	public void shouldResizeDigit() throws Exception {
		List<String> oneSized = Arrays.asList(" - ", "|  ", " - ", "| |", " - ");
		
		assertEquals(new AsciiPicture(oneSized), AsciiPictures.asPicture(6, 1));
	}
}
