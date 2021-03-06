package my.fizzbuzz;

public class Game {

	private int counted;

	public Game() {
		this(0);
	}

	public Game(int fromValue) {
		counted = fromValue;
	}

	public String nextTurn() {
		countNext();

		Player player = new Player();

		if (multipleOf(3)) {
			player.say("Fizz");
		}

		if (multipleOf(5)) {
			player.say("Buzz");
		}

		if (player.nothingSaid()) {
			player.say(current());
		}

		return player.message();
	}

	private int current() {
		return counted;
	}

	private boolean multipleOf(int amount) {
		return current() % amount == 0;
	}

	private void countNext() {
		counted++;
	}

}
