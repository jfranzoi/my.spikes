package my;

import static org.junit.Assert.*;

import org.junit.Test;

public class AcceptanceTest {

	@Test
	public void upToThree() {
		FizzBuzzGame game = new FizzBuzzGame();

		assertEquals("1", game.nextTurn());
		assertEquals("2", game.nextTurn());
		assertEquals("Fizz", game.nextTurn());
	}

	@Test
	public void upToFive() throws Exception {
		FizzBuzzGame game = new FizzBuzzGame(3);

		assertEquals("4", game.nextTurn());
		assertEquals("Buzz", game.nextTurn());
	}

	@Test
	public void upToTwelve() throws Exception {
		FizzBuzzGame game = new FizzBuzzGame(5);
		
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
		FizzBuzzGame game = new FizzBuzzGame(12);
		
		assertEquals("13", game.nextTurn());
		assertEquals("14", game.nextTurn());
		assertEquals("Fizz Buzz", game.nextTurn());
	}

}
