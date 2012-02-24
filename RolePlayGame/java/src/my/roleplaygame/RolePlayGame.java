package my.roleplaygame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RolePlayGame {
	private static final List<String> allowedSpecies = Arrays.asList("Human", "Lizard");

	private List<GameCharacter> characters;
	private int currentTurn = 0;
	private String message;

	public RolePlayGame() {
		this(new ArrayList<GameCharacter>());
	}
	
	public RolePlayGame(List<GameCharacter> characters) {
		this.characters = characters;
		this.message = "";
	}

	public void createCharacter(String aName) {
		addCharacter(new GameCharacter(aName));
	}

	public void addCharacter(GameCharacter newCharater) {
		if(characters.contains(newCharater)){
			return;
		}
		
		newCharater.register(new CharacterEventSubscriber(){
			public void onDied(GameCharacter diedCharacter){
				characters.remove(diedCharacter);
			}
			public void onInvalidAction(GameCharacter aCharacter, Action invalidAction){
				message = invalidAction.message();
			}
		});
		
		characters.add(newCharater);
	}

	public List<GameCharacter> characters() {
		return characters;
	}

	public GameCharacter currentTurn() {
		if(characters.isEmpty()){
			return new GameCharacter("");
		}
		return characters.get(currentTurn);
	}

	public void advanceTurn() {
		currentTurn = increase_OrStartFromBeginning(currentTurn);
	}

	private int increase_OrStartFromBeginning(int turn) {
		return (turn + 1) % characters.size();
	}

	public String message() {
		return message;
	}

	public List<String> carriedItems() {
		return currentTurn().items();
	}

	public void createCharacter(String aName, String aSpecies) {
		if(allowedSpecies.contains(aSpecies)){
			addCharacter(new GameCharacter(aName, aSpecies));
			return;
		}
		message = "the only valid species types are Human and Lizard";
	}

}
