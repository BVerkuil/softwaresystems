package ss.week4;

public class Polynomial implements Function, Integrandable {

	private LinearProduct[] parts;

	
	public Polynomial(double[] newArray) {
		parts = new LinearProduct[newArray.length];
		for (int i = 0; i < parts.length; i++) {
			parts[i] = new LinearProduct(new Exponent(i) ,new Constant( newArray[i]));
		}
		
	}
	
	public double apply(double number) {
		double result = 0.0;
		for (int i = 0; i < parts.length; i++) {
			result = result + parts[i].apply(number);
		}
		return result;
	}


	public Function derivative() {
		Sum deriv = new Sum(new Constant(0), new Constant(0));
		for (int i = 0; i < parts.length; i++) {
			 deriv = new Sum(deriv, parts[i].derivative());
		}
		return deriv;
	}

	public Function integrand() {
		Sum integ = new Sum(new Constant(0), new Constant(0));
		for (int i = 0; i < parts.length; i++) {
			 integ = new Sum(integ, parts[i].integrand());
		}
		return integ;
	}
}
