import java.util.ArrayList;
import java.util.List;

import my.roleplaygame.GameCharacter;
import my.roleplaygame.RolePlayGame;
import fit.Fixture;


public class GameFixture extends Fixture {

	static RolePlayGame game;
	static List<GameCharacter> characters;
	
	private String characterName;
	private Command lastCommand;
	private int healthLevel;
	private String versus;
	private String itemName;
	private String species;

	
	public GameFixture() {
		super();
		characters = new ArrayList<GameCharacter>();
		game = new RolePlayGame(characters);
	}
	
	public void createCharacter(){
		lastCommand = new Command(){
			public void execute() {
				if(species != null){
					game.createCharacter(characterName, species);
				} else {
					game.createCharacter(characterName);
				}
			}
		};
	}
	
	public void name(String aName){
		characterName = aName;
	}
	
	public void ok(){
		lastCommand.execute();
	}
	
	public String currentTurn(){
		return game.currentTurn().name();
	}
	
	public void advanceTurn(){
		game.advanceTurn();
	}
	
	public void damage(){
		lastCommand = new Command(){
			public void execute() {
				GameHelper.characterWithName(versus, characters).damagedBy(healthLevel);
			}
		};
	}
	
	public void healthLevel(int healthLevel){
		this.healthLevel = healthLevel;
	}
	
	public void versus(String characterName){
		versus = characterName;
	}
	
	public void pickUpItem(){
		lastCommand = new Command(){
			public void execute() {
				game.currentTurn().pickup(itemName);
			}
		};
	}
	
	public void itemName(String itemName){
		this.itemName = itemName;
	}
	
	public String[] itemsDisplayed(){
		return GameHelper.toStringArray(game.carriedItems());
	}
	
	public void discardItem(){
		lastCommand = new Command(){
			public void execute() {
				game.currentTurn().discard(itemName);
			}
		};
	}
	
	public String message(){
		return game.message();
	}
	
	public void species(String aSpecies){
		species = aSpecies;
	}
}
