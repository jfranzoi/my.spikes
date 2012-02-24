import my.roleplaygame.GameCharacter;
import fitlibrary.DoFixture;


public class CharacterFixture extends DoFixture {

	private final GameCharacter character;

	public CharacterFixture(GameCharacter aCharacter) {
		this.character = aCharacter;
	}

	public void isDamagedByHealthLevelPoints(int healthLevelPoints){
		character.damagedBy(healthLevelPoints);
	}
	
	public void isHealedByHealthLevelPoints(int healthLevelPoints){
		character.receivedHealingOf(healthLevelPoints);
	}
	
	public int itsHealthLevelIs(){
		return character.healthLevel();
	}

	public void pickUpThe(String itemName){
		character.pickup(itemName);
	}
	
	public String[] itsItemsAre(){
		return GameHelper.toStringArray(character.items());
	}
	
	public void discardThe(String itemName){
		character.discard(itemName);
	}
}
