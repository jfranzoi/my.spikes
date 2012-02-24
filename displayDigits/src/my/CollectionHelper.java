package my;

import java.util.ArrayList;
import java.util.List;

public class CollectionHelper {

	public static <T> List<T> collect_StartingFrom(List<T> collection, int startingItem) {
		ArrayList<T> collected = new ArrayList<T>();
		for (int eachItem = startingItem; eachItem < collection.size(); eachItem++) {
			collected.add(collection.get(eachItem));
		}
		return collected;
	}

	public static <T> void add_Times_To(int timesToAdd, T aString, List<T> aCollection) {
		for (int i = 0; i < timesToAdd; i++) {
			aCollection.add(aString);
		}
	}

}
