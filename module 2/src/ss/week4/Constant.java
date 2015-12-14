package ss.week4;

public class Constant implements Function, Integrandable {

	private double constant;
	
	public Constant(double constant) {
		this.constant = constant;
	}
	
	public double apply(double number) {
		return this.constant;
	}

	public Function derivative() {
		return new Constant(0);
	}
	
	public String toString() {
		return ""+this.constant;
	}

	public Function integrand() {
		return new LinearProduct(new Exponent(1), new Constant(constant));
	}
	

}
