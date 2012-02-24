package my.examples;

import java.util.ArrayList;
import java.util.List;

public class UserGateway {

	public List<User> teens() {
		List<User> teens = new ArrayList<User>();
		
		for (User eachUser : Db.allUsers()) {
			if(eachUser.isUnder(16)){
				teens.add(eachUser);
			}
		}
		
		return teens;
	}
}
