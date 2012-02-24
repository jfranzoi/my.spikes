using fit;

using System;
using System.Collections.Generic;

namespace my.examples {

	public class TeenagersFixture : RowFixture {
	
		public override Type GetTargetClass() {
			return typeof(User);
		}
	
		public override object[] Query() {
			UserGateway users = new UserGateway(); // system under test
			List<User> teens = users.Teens();
			return teens.ToArray();
		}
	}

}