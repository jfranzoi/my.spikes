import java.util.ArrayList;

import my.roleplaygame.GameCharacter;
import my.roleplaygame.RolePlayGame;
import adapters.CharactersAdapter;
import fit.RowFixture;


public class CharactersFixture extends RowFixture {
	private RolePlayGame game;
	
	public CharactersFixture() {
		this(GameFixture.game);
	}
	
	public CharactersFixture(RolePlayGame aGame) {
		super();
		game = aGame;
	}

	@Override
	public Class getTargetClass() {
		return CharactersAdapter.class;
	}

	@Override
	public Object[] query() throws Exception {
		ArrayList<CharactersAdapter> adapters = new ArrayList<CharactersAdapter>();
		for (GameCharacter eachCharacter : game.characters()) {
			adapters.add(adapterForm(eachCharacter));
		}
		return adapters.toArray();
	}

	private CharactersAdapter adapterForm(GameCharacter aCharacter) {
		CharactersAdapter adapter = new CharactersAdapter();
		adapter.name = aCharacter.name();
		adapter.healthLevel = aCharacter.healthLevel();
		adapter.items = GameHelper.toStringArray(aCharacter.items());
		adapter.species = aCharacter.species();
		adapter.weapons = GameHelper.toStringArray(aCharacter.weapons());
		return adapter;
	}

}
