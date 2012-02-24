import java.util.List;

import my.roleplaygame.GameCharacter;


public class GameHelper {

	public static GameCharacter characterWithName(String characterName, List<GameCharacter> someCharacters) {
		for (GameCharacter eachCharacter : someCharacters) {
			if(eachCharacter.name().equals(characterName)){
				return eachCharacter;
			}
		}
		return null;
	}

	public static String[] toStringArray(List<String> list) {
		String[] emptyArray = new String[0];
		
		if(list == null){
			return emptyArray;
		}
		return list.toArray(emptyArray);
	}

}
