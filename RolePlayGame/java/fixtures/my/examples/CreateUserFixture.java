package my.examples;

import fitlibrary.SetUpFixture;

public class CreateUserFixture extends SetUpFixture {

	public void nameAge(String name, int age){
		Db.insert(new User(name, age));
	}
}
