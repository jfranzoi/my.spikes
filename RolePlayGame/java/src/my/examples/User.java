package my.examples;

public class User {

	public final String name;
	public final int age;

	public User(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public boolean isUnder(int anAge) {
		return age < anAge;
	}
}
