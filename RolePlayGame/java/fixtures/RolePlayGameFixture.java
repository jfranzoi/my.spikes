import java.util.ArrayList;
import java.util.List;

import my.roleplaygame.GameCharacter;
import my.roleplaygame.RolePlayGame;
import fitlibrary.DoFixture;


public class RolePlayGameFixture extends DoFixture {
	
	private RolePlayGame game;
	private List<GameCharacter> characters;
	
	public RolePlayGameFixture() {
		super();
		characters = new ArrayList<GameCharacter>();
		game = new RolePlayGame(characters);
	}

	public CharactersFixture charactersAre(){
		return new CharactersFixture(game);
	}
	
	public void createCharacter(String aName){
		new SetupCharacterFixture(game).name(aName);
	}
	
	public String currentTurnIs(){
		return game.currentTurn().name();
	}
	
	public void advanceTurn(){
		game.advanceTurn();
	}
	
	public void createCharacterWithHealthLevel(String aName, int healthLevel){
		new SetupCharacterFixture(game).nameHealthLevel(aName, healthLevel);
	}
	
	public CharacterFixture when(String characterName){
		return new CharacterFixture(characterWithName(characterName));
	}
	
	public String[] itemsDisplayedAre(){
		return GameHelper.toStringArray(game.carriedItems());
	}
	
	public void createCharacterWith(String aName, String[] items){
		new SetupCharacterFixture(game).nameItems(aName, items);
	}
	
	public String messageIs(){
		return game.message();
	}
	
	public void createCharacterOfSpecies(String aName, String aSpecies){
		game.createCharacter(aName, aSpecies);
	}
	
	private GameCharacter characterWithName(String characterName) {
		return GameHelper.characterWithName(characterName, characters);
	}
	
}
