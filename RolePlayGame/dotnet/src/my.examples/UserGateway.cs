using System.Collections.Generic;

namespace my.examples {

	public class UserGateway {
	
		public List<User> Teens() {
			List<User> teens = new List<User>();
			
			foreach (User eachUser in Db.AllUsers()) {
				if(eachUser.IsUnder(16)){
					teens.Add(eachUser);
				}
			}
			
			return teens;
		}
	}
}