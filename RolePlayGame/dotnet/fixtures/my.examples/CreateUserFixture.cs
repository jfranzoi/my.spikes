using fitlibrary;

namespace my.examples {

	public class CreateUserFixture : SetUpFixture {
	
		public void NameAge(string name, int age){
			Db.Insert(new User(name, age));
		}
	}
}