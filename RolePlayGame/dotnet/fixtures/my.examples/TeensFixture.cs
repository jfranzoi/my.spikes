using fitlibrary;

namespace my.examples {

	public class TeensFixture : DoFixture {
		
		public UserFixture Insert(){
			return new UserFixture();
		}
		
		public TeenagersFixture TeenagersAre(){
			return new TeenagersFixture();
		}
	}
}