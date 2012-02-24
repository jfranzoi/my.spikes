using fitlibrary;

namespace my.examples {

	public class UserFixture : DoFixture {
	
		public void UserWhichIsYearsOld(string name, int age){
			Db.Insert(new User(name, age));
		}
	}
}