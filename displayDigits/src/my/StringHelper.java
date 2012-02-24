package my;

import java.util.List;

public class StringHelper {
	public static final String newline = "\n";
	
	public static String joinWithNewLine(List<String> characters) {
		return joinWithNewLine(asStringArray(characters));
	}

	public static String joinWithNewLine(String... strings) {
		
		StringBuilder builder = new StringBuilder();
		for (String eachString : strings) {
			builder.append(eachString);
			builder.append(newline);
		}
		return StringHelper.removeLast_From(newline, builder.toString());
	}

	private static String removeLast_From(String toRemove, String target) {
		return target.substring(0, target.length() - toRemove.length());
	}

	private static String[] asStringArray(List<String> lines) {
		return lines.toArray(new String[0]);
	}

	public static String repeat_Times(int times, String aString) {
		String result = "";
		for (int i = 0; i < times; i++) {
			result = result.concat(aString);
		}
		return result;
	}

	public static Integer asInteger(Character aCharacter) {
		return Integer.parseInt(String.valueOf(aCharacter));
	}

}
