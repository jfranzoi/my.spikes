package my.examples;

import java.util.ArrayList;
import java.util.List;

public class Db {
	private static List<User> users = new ArrayList<User>();

	public static void insert(User aUser) {
		users .add(aUser);
	}

	public static List<User> allUsers() {
		return users;
	}

	public static void reset() {
		users.clear();
	}

}
