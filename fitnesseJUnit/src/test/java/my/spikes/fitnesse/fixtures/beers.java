package my.spikes.fitnesse.fixtures;

public class beers {

	private int age;

	public void setAge(int age) {
		this.age = age;
	}

	public String allowed() {
		return age > 14 ? "yes" : "no";
	}
}
