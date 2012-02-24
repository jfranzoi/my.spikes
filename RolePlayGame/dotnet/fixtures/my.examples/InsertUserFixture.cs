using fit;

namespace my.examples {

	public class InsertUserFixture : ColumnFixture {
	
		public string name;
		public int age;
		
		public bool Ok(){
			Db.Insert(new User(name, age));
			return true;
		}
	}

}