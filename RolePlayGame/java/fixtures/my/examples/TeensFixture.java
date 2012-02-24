package my.examples;

import fitlibrary.DoFixture;

public class TeensFixture extends DoFixture {
	
	public UserFixture insert(){
		return new UserFixture();
	}
	
	public TeenagersFixture teenagersAre(){
		return new TeenagersFixture();
	}
}
