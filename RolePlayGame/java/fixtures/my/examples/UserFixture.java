package my.examples;

import fitlibrary.DoFixture;

public class UserFixture extends DoFixture{

	public void userWhichIsYearsOld(String name, int age){
		Db.insert(new User(name, age));
	}
}
