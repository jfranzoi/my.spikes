package my.examples;

import fitlibrary.DoFixture;

public class CalculatorThreeFixture extends DoFixture {

	public double quotientOfAndIs(double numerator, double denominator){
		Calculator calculator = new Calculator(); // system under test
		return calculator.quotientFor(numerator, denominator);
	}
}
