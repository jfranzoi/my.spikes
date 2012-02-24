import my.roleplaygame.GameCharacter;
import my.roleplaygame.HealthLevel;
import fit.ColumnFixture;


public class DamageFixture extends ColumnFixture {

	public int health;
	public int damage;
	
	public int currentHealth(){
		GameCharacter anyCharacter = new GameCharacter("anyName", new HealthLevel(health));
		anyCharacter.damagedBy(damage);
		return anyCharacter.healthLevel();
	}
	
}
