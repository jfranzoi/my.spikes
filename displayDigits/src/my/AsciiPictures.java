package my;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class AsciiPictures {

	public static final List<String> ZERO	= Arrays.asList(" - ", "| |", "   ", "| |", " - ");
	public static final List<String> ONE	= Arrays.asList("   ", "  |", "   ", "  |", "   ");
	public static final List<String> TWO	= Arrays.asList(" - ", "  |", " - ", "|  ", " - ");
	public static final List<String> THREE	= Arrays.asList(" - ", "  |", " - ", "  |", " - ");
	public static final List<String> FOUR	= Arrays.asList("   ", "| |", " - ", "  |", "   ");
	public static final List<String> FIVE	= Arrays.asList(" - ", "|  ", " - ", "  |", " - ");
	public static final List<String> SIX	= Arrays.asList(" - ", "|  ", " - ", "| |", " - ");
	public static final List<String> SEVEN	= Arrays.asList(" - ", "  |", "   ", "  |", "   ");
	public static final List<String> EIGHT	= Arrays.asList(" - ", "| |", " - ", "| |", " - ");
	public static final List<String> NINE	= Arrays.asList(" - ", "| |", " - ", "  |", " - ");
	
	private static final HashMap<Integer, List<String>> asciiStrings;
	
	static {
		asciiStrings = new HashMap<Integer, List<String>>();
		
		asciiStrings.put(0, ZERO);
		asciiStrings.put(1, ONE);
		asciiStrings.put(2, TWO);
		asciiStrings.put(3, THREE);
		asciiStrings.put(4, FOUR);
		asciiStrings.put(5, FIVE);
		asciiStrings.put(6, SIX);
		asciiStrings.put(7, SEVEN);
		asciiStrings.put(8, EIGHT);
		asciiStrings.put(9, NINE);
	}
	
	public static AsciiPicture asPicture(Integer value, int size) {
		return new AsciiPicture(digitFor(value)).resizedTo(size);
	}

	private static List<String> digitFor(int value) {
		return asciiStrings.get(value);
	}

}
