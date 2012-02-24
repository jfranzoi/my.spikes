package my.examples;

import fit.Fixture;

public class CalculatorTwoFixture extends Fixture {
	private double numerator;
	private double denominator;
	private double result;

	public void numerator(double aNumerator){
		this.numerator = aNumerator;
	}
	
	public void denominator(double aDenominator){
		this.denominator = aDenominator;
	}
	
	public void quotient(){
		Calculator calculator = new Calculator();
		this.result = calculator.quotientFor(numerator, denominator);
	}
	
	public double result(){
		return this.result;
	}
}
