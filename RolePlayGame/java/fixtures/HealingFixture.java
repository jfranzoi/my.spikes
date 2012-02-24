import my.roleplaygame.GameCharacter;
import my.roleplaygame.HealthLevel;
import fit.ColumnFixture;


public class HealingFixture extends ColumnFixture {

	public int health;
	public int healing;
	
	public int currentHealth(){
		GameCharacter anyCharacter = new GameCharacter("anyName", new HealthLevel(health));
		anyCharacter.receivedHealingOf(healing);
		return anyCharacter.healthLevel();
	}
}
