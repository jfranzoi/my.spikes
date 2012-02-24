package my.examples;

import java.util.List;

import fit.RowFixture;

public class TeenagersFixture extends RowFixture {

	public Class getTargetClass() {
		return User.class;
	}

	public Object[] query() throws Exception {
		UserGateway users = new UserGateway(); // system under test
		List<User> teens = users.teens();
		return teens.toArray();
	}
}
