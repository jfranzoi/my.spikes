package my.roleplaygame;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;


public class RolePlayGameTest {

	private RolePlayGame game;
	private ArrayList<GameCharacter> characters;

	@Before
	public void setUp(){
		characters = new ArrayList<GameCharacter>();
		game = new RolePlayGame(characters);
	}
	
	@Test
	public void shouldCreateCharacterWithDefaultHealthLevel() throws Exception {
		game.createCharacter("Thorr");
		assertEquals(Arrays.asList(new GameCharacter("Thorr", new HealthLevel(100))), game.characters());
	}
	
	@Test
	public void shouldNotCreateDuplicateCharacters() throws Exception {
		game.createCharacter("Thorr");
		game.createCharacter("Thorr");
		
		assertEquals(Arrays.asList(new GameCharacter("Thorr")), game.characters());		
	}
	
	@Test
	public void shouldStartFromFirstCharacter() throws Exception {
		assertEquals(new GameCharacter(""), game.currentTurn());
		
		game.createCharacter("Thorr");
		assertEquals(new GameCharacter("Thorr"), game.currentTurn());
	}
	
	@Test
	public void shouldAdvanceTurnInCircle() throws Exception {
		GameCharacter thorr = new GameCharacter("Thorr");
		GameCharacter astrid = new GameCharacter("Astrid");
		
		game.createCharacter("Thorr");
		game.createCharacter("Astrid");
		
		assertEquals(thorr, game.currentTurn());
		
		game.advanceTurn();
		assertEquals(astrid, game.currentTurn());
		
		game.advanceTurn();
		assertEquals(thorr, game.currentTurn());
	}
	
	@Test
	public void shouldRemoveDiedCharacters() throws Exception {
		game.createCharacter("Thorr");
		GameCharacter thorr = characters.get(0);
		
		thorr.damagedBy(50);
		assertTrue(characters.contains(thorr));
		
		thorr.damagedBy(250);
		assertTrue(characters.isEmpty());
	}
	
	@Test
	public void shouldDisplayCarriedItems() throws Exception {
		game.createCharacter("Thorr");
		GameCharacter thorr = characters.get(0);
		
		thorr.pickup("key");
		thorr.pickup("map");
		
		assertEquals(Arrays.asList("key", "map"), game.carriedItems());
	}
	
	@Test
	public void shouldAlertWhenCharacterWithNoItemsTyiesToDiscardSomething() throws Exception {
		game.createCharacter("Thorr");
		GameCharacter thorr = characters.get(0);
		
		thorr.discard("anyItem");
		assertEquals("the character is carrying no items", game.message());
	}
	
	@Test
	public void shouldCreateCharacterOfGivenSpecies() throws Exception {
		game.createCharacter("Thorr", "Human");
		assertEquals(Arrays.asList(new GameCharacter("Thorr", "Human")), characters);
	}
	
	@Test
	public void shouldCreateOnlyHumansAndLizards() throws Exception {
		game.createCharacter("Thorr", "Human");
		game.createCharacter("Astrid", "Lizard");
		GameCharacter thorr = new GameCharacter("Thorr", "Human");
		GameCharacter astrid = new GameCharacter("Astrid", "Lizard");
		
		assertEquals(Arrays.asList(thorr, astrid), characters);
		
		game.createCharacter("Thorr", "Elf");
		
		assertEquals(Arrays.asList(thorr, astrid), characters);
		assertEquals("the only valid species types are Human and Lizard", game.message());
	}
	
	@Test
	public void shouldCreateHumanWithSword() throws Exception {
		game.createCharacter("Thorr", "Human");
		GameCharacter thorr = characters.get(0);
		
		assertEquals(Arrays.asList("sword"), thorr.weapons());
	}
	
	@Test
	public void shouldCreateLizardWithClub() throws Exception {
		game.createCharacter("Astrid", "Lizard");
		GameCharacter astrid = characters.get(0);
		
		assertEquals(Arrays.asList("club"), astrid.weapons());
	}
}
