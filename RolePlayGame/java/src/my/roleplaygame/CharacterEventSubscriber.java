package my.roleplaygame;

public interface CharacterEventSubscriber {

	void onDied(GameCharacter subject);

	void onInvalidAction(GameCharacter character, Action invalidAction);

}
