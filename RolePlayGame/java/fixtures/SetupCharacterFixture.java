import my.roleplaygame.GameCharacter;
import my.roleplaygame.HealthLevel;
import my.roleplaygame.RolePlayGame;
import fitlibrary.SetUpFixture;


public class SetupCharacterFixture extends SetUpFixture {

	private final RolePlayGame game;
	
	public SetupCharacterFixture(){
		this(GameFixture.game);
	}
	
	public SetupCharacterFixture(RolePlayGame game){
		super();
		this.game = game;
	}

	private RolePlayGame game() {
		return game;
	}
	
	public void name(String aName){
		game().createCharacter(aName);
	}
	
	public void nameHealthLevel(String aName, int healthLevel){
		game().addCharacter(new GameCharacter(aName, new HealthLevel(healthLevel)));
	}
	
	public void nameItems(String aName, String[] items){
		GameCharacter aCharacter = new GameCharacter(aName);
		for (String eachItem : items) {
			aCharacter.pickup(eachItem);
		}
		game().addCharacter(aCharacter);
	}
}
