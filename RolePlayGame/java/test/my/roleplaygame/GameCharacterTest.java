package my.roleplaygame;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;


public class GameCharacterTest {

	private GameCharacter thorr;
	private GameCharacter astrid;

	@Before
	public void setUp(){
		thorr = new GameCharacter("Thorr", "Human");
		astrid = new GameCharacter("Astrid", new HealthLevel(10));
	}
	
	@Test
	public void equality() throws Exception {
		assertTrue(thorr.equals(new GameCharacter("Thorr", "Human")));
		
		assertFalse(thorr.equals(new GameCharacter("Thorr", "Lizard")));
		assertFalse(thorr.equals(new GameCharacter("Thorr", new HealthLevel(0))));
		
		assertEquals(thorr.hashCode(), new GameCharacter("Thorr").hashCode());
	}
	
	@Test
	public void shouldDecreaseHealthWhenDamaged() throws Exception {
		thorr.damagedBy(20);
		assertEquals(80, thorr.healthLevel());
	}
	
	@Test
	public void shouldNotHaveLessThanZeroHealthLevel() throws Exception {
		astrid.damagedBy(20);
		assertEquals(0, astrid.healthLevel());
	}
	
	@Test
	public void shouldDieOnZeroHealthLevel() throws Exception {
		assertFalse(astrid.hasDied());
		
		astrid.damagedBy(20);
		assertTrue(astrid.hasDied());
	}
	
	@Test
	public void shouldIncreaseHealthWhenHealingReceived() throws Exception {
		astrid.receivedHealingOf(20);
		assertEquals(30, astrid.healthLevel());
	}
	
	@Test
	public void shouldHaveNoMoreThanHundredHealthPoints() throws Exception {
		thorr.receivedHealingOf(20);
		assertEquals(100, thorr.healthLevel());
	}
	
	@Test
	public void shouldHaveNoItemsByDefault() throws Exception {
		assertTrue(thorr.items().isEmpty());
	}
	
	@Test
	public void shouldCollectPickedUpItemsAndRemoveDiscardedItems() throws Exception {
		thorr.pickup("key");
		assertEquals(Arrays.asList("key"), thorr.items());
		
		thorr.discard("key");
		assertTrue(thorr.items().isEmpty());
	}
	
}
