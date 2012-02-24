package my.examples;

import fit.ColumnFixture;

public class InsertUserFixture extends ColumnFixture {

	public String name;
	public int age;
	
	public boolean ok(){
		Db.insert(new User(name, age));
		return true;
	}
}
