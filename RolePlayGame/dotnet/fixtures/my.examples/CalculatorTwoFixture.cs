using fit;

namespace my.examples {

	public class CalculatorTwoFixture : Fixture {
		private double numerator;
		private double denominator;
		private double result;
	
		public double Numerator { set { numerator = value; } }
		
		public double Denominator { set { denominator = value; } }
		
		public void Quotient(){
			Calculator calculator = new Calculator(); // system under test
			result = calculator.QuotientFor(numerator, denominator);
		}
		
		public double Result { get { return result; } }
	}
}