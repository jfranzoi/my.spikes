package my.examples;

import fitlibrary.DoFixture;

public class DeleteAllUsersFixture extends DoFixture{

	public void now(){
		Db.reset();
	}
}
