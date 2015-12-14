package ss.week4;

public class Product implements Function {
	
	protected Function g;
	protected Function h;
	
	public Product(Function g, Function h) {
		this.g = g;
		this.h = h;
	}
	
	public double apply(double number) {
		return g.apply(number) * h.apply(number);
	}

	public Function derivative() {
		return new Sum(new Product(g.derivative(), h) , new Product (h.derivative(), g));
	}
	
	public String toString() {
		return "" + this.g + "*" + this.h;
	}

}

