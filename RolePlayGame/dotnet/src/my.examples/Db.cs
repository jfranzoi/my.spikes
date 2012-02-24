using System;
using System.Collections.Generic;

namespace my.examples {

	public class Db {
		private static IList<User> users = new List<User>();
	
		public static void Insert(User aUser) {
			users.Add(aUser);
		}
	
		public static IList<User> AllUsers() {
			return users;
		}
		
		public static void Reset(){
			users.Clear();
		}
	}
	
}
