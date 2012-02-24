package my;

import java.util.ArrayList;
import java.util.List;

public class CommandLine {
	
	public static CommandLineParameters parse(String... commandLineArguments) {
		String digits = noDigits();
		String size = defaultSize();
	
		if (hasBothDigitsAndSize(commandLineArguments)) {
			digits = commandLineArguments[2];
			size = commandLineArguments[1];
		} else if (hasDigits(commandLineArguments)){
			digits = commandLineArguments[0];
		}
	
		return commandLineFrom(digits, size);
	}
	
	private static void add_AsIntegersTo(String digits, List<Integer> values) {
		for (Character eachCharacter : digits.toCharArray()) {
			values.add(StringHelper.asInteger(eachCharacter));
		}
	}

	private static CommandLineParameters commandLineFrom(String digits, String size) {
		List<Integer> values = new ArrayList<Integer>();
		
		try {
			add_AsIntegersTo(digits, values);
		} catch (NumberFormatException stringIsNotANumber) {
			return invalid();
		}
		
		return new CommandLineParameters(values, Integer.valueOf(size));
	}

	private static String defaultSize() {
		return "2";
	}

	private static String noDigits() {
		return "";
	}

	private static boolean hasBothDigitsAndSize(String... commandLineArguments) {
		return commandLineArguments.length == 3;
	}

	private static boolean hasDigits(String... commandLineArguments) {
		return commandLineArguments.length == 1;
	}
	
	private static CommandLineParameters invalid(){
		return new CommandLineParameters(new ArrayList<Integer>(), 0){
			@Override
			public boolean areValid() {
				return false;
			}
		};
	}
}
