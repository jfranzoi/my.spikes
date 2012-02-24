package my.roleplaygame;

import java.util.ArrayList;
import java.util.List;

public class GameCharacter {
	private final String itsName;
	private final HealthLevel itsHealth;
	private final ArrayList<String> item;
	
	private final List<CharacterEventSubscriber> subscribers;
	private final String itsSpecies;

	private List<String> weapons;
	
	public GameCharacter(String name) {
		this(name, new HealthLevel(), "");
	}

	public GameCharacter(String aName, String aSpecies) {
		this(aName, new HealthLevel(), aSpecies);
	}

	public GameCharacter(String name, HealthLevel healthLevel) {
		this(name, healthLevel, "");
	}
		
	private GameCharacter(String name, HealthLevel healthLevel, String aSpecies) {
		this.itsName = name;
		this.itsHealth = healthLevel;
		this.itsSpecies = aSpecies;
		this.item = new ArrayList<String>();
		this.weapons = DefaultWeapons.forSpecies(itsSpecies);
		
		this.subscribers = new ArrayList<CharacterEventSubscriber>();
	}


	public String name(){
		return itsName;
	}
	
	public int healthLevel() {
		return itsHealth.points();
	}
	
	@Override
	public boolean equals(Object obj) {
		GameCharacter character = (GameCharacter)obj;
		return	character.itsName.equals(itsName) && 
				character.itsHealth.equals(itsHealth) &&
				character.itsSpecies.equals(itsSpecies);
	}
	
	@Override
	public int hashCode() {
		return itsName.hashCode();
	}
	
	@Override
	public String toString() {
		return itsName + " the " + itsSpecies + " with health level " + itsHealth.points();
	}

	public void damagedBy(int healthPoints) {
		itsHealth.decreaseBy(healthPoints);
		if(hasDied()){
			notifyDeath();
		}
	}

	private void notifyDeath() {
		for (CharacterEventSubscriber eachSubscriber : subscribers) {
			eachSubscriber.onDied(this);
		}
	}
	
	public boolean hasDied() {
		return itsHealth.isEmpty();
	}

	public void receivedHealingOf(int healthPoints) {
		itsHealth.increaseBy(healthPoints);
	}

	public void register(CharacterEventSubscriber eventSubscriber) {
		this.subscribers.add(eventSubscriber);
	}

	public List<String> items() {
		return item;
	}
	
	public String species() {
		return itsSpecies;
	}

	public void pickup(String anItem) {
		item.add(anItem);
	}

	public void discard(String anItem) {
		if(item.isEmpty()){
			notifyDiscardOnEmptyItems();
		}
		item.remove(anItem);
	}

	private void notifyDiscardOnEmptyItems() {
		for (CharacterEventSubscriber eachSubscriber : subscribers) {
			eachSubscriber.onInvalidAction(this, new Action("the character is carrying no items"));
		}
	}

	public List<String> weapons() {
		return weapons;
	}

}
