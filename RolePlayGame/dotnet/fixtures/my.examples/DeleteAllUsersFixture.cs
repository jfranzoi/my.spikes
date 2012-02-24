using fitlibrary;

namespace my.examples {
	public class DeleteAllUsersFixture : DoFixture {
		
		public void Now(){
			Db.Reset();
		}
	}
}