package my.fizzbuzz;

import static org.junit.Assert.*;

import org.junit.Test;

public class AcceptanceTest {

	@Test
	public void upToThree() {
		Game game = new Game();

		assertEquals("1", game.nextTurn());
		assertEquals("2", game.nextTurn());
		assertEquals("Fizz", game.nextTurn());
	}

	@Test
	public void upToFive() throws Exception {
		Game game = new Game(3);

		assertEquals("4", game.nextTurn());
		assertEquals("Buzz", game.nextTurn());
	}

	@Test
	public void upToTwelve() throws Exception {
		Game game = new Game(5);
		
		assertEquals("Fizz", game.nextTurn());
		assertEquals("7", game.nextTurn());
		assertEquals("8", game.nextTurn());
		assertEquals("Fizz", game.nextTurn());
		assertEquals("Buzz", game.nextTurn());
		assertEquals("11", game.nextTurn());
		assertEquals("Fizz", game.nextTurn());
	}

	@Test
	public void upToFifteen() throws Exception {
		Game game = new Game(12);
		
		assertEquals("13", game.nextTurn());
		assertEquals("14", game.nextTurn());
		assertEquals("Fizz Buzz", game.nextTurn());
	}

}
