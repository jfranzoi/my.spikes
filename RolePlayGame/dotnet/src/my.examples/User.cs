namespace my.examples {

	public class User {
	
		public string name;
		public int age;
	
		public User(string name, int age) {
			this.name = name;
			this.age = age;
		}
	
		public bool IsUnder(int anAge) {
			return age < anAge;
		}
	}
}