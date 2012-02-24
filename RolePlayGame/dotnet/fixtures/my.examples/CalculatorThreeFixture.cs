using fitlibrary;

namespace my.examples {

	public class CalculatorThreeFixture : DoFixture {
	
		public double QuotientOfAndIs(double numerator, double denominator){
			Calculator calculator = new Calculator(); // system under test
			return calculator.QuotientFor(numerator, denominator);
		}
	}
}