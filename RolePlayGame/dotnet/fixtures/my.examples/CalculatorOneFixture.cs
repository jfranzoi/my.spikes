using fit;

namespace my.examples {

	public class CalculatorOneFixture : ColumnFixture {
		public double numerator;
		public double denominator;
		
		public double Quotient(){
			Calculator calculator = new Calculator(); // system under test
			return calculator.QuotientFor(numerator, denominator);
		}
	}
}