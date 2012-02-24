package my;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;


public class StringHelperTest {

	@Test
	public void shouldJoinArrayItemsWithNewlines() throws Exception {
		assertEquals("1\n2", StringHelper.joinWithNewLine("1", "2"));
	}
	
	@Test
	public void shouldJoinListWithNewlines() throws Exception {
		assertEquals("1\n2", StringHelper.joinWithNewLine(Arrays.asList("1", "2")));
	}
	
	@Test
	public void shouldGetIntegers() throws Exception {
		assertEquals(1, StringHelper.asInteger('1'));
	}
}
