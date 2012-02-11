package my.fizzbuzz;

import java.util.ArrayList;
import java.util.List;

public class Player {

	List<String> words = new ArrayList<String>();

	public void say(int word) {
		say(asString(word));
	}

	public void say(String word) {
		words.add(word);
	}

	public boolean nothingSaid() {
		return words.isEmpty();
	}

	public String message() {
		return Strings.joinWith(" ", words);
	}

	private String asString(int word) {
		return String.valueOf(word);
	}
}
