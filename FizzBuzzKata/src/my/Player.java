package my;

import java.util.ArrayList;
import java.util.Iterator;
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
		return joinWith(" ", words);
	}

	private String asString(int word) {
		return String.valueOf(word);
	}

	private String joinWith(String delimiter, List<String> items) {
		StringBuilder result = new StringBuilder();
		Iterator<String> iterator = items.iterator();
		while (iterator.hasNext()) {
			result.append(iterator.next());
			if (!iterator.hasNext()) {
				break;
			}
			result.append(delimiter);
		}
		return result.toString();
	}
}
