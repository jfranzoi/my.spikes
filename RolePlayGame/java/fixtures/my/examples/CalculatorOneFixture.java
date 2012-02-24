package my.examples;

import fit.ColumnFixture;

public class CalculatorOneFixture extends ColumnFixture {
	public double numerator;
	public double denominator;
	
	public double quotient(){
		Calculator calculator = new Calculator(); // system under test
		return calculator.quotientFor(numerator, denominator);
	}
}
