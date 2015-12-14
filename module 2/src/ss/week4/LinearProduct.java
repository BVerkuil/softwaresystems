package ss.week4;

public class LinearProduct extends Product implements Integrandable {
	
	public LinearProduct(Function g, Constant h) {
		super(g,h);
	}
	public Function derivative() {
		return new LinearProduct(g.derivative(), ((Constant) h));
	}

	public Function integrand() {
		if (g instanceof Integrandable) {
			return new LinearProduct(((Integrandable) g).integrand(), ((Constant) h));
		}else{
			return null;
		}	
	}
	
	public String toString() {
		return "" + this.g + "*" + this.h;
	}
}

