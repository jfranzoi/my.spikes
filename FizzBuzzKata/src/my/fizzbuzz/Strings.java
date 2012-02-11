package my.fizzbuzz;

import java.util.Iterator;
import java.util.List;

public class Strings {

	public static String joinWith(String delimiter, List<String> items) {
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
