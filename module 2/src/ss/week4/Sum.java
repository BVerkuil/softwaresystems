package ss.week4;

public class Sum implements Function, Integrandable {

	private Function g;
	private Function h;
	
	public Sum(Function g, Function h) {
		this.g = g;
		this.h = h;
	}
	
	public double apply(double number) {
		return g.apply(number) + h.apply(number);
	}

	public Function derivative() {
		return new Sum(g.derivative(), h.derivative());
	}
	
	public String toString() {
		return g.toString() + "+" + h.toString();
	}
	
	public Function integrand() {
		if (g instanceof Integrandable && h instanceof Integrandable) {
			return new Sum(((Integrandable) g).integrand(), (Integrandable) h).integrand();
		}else{
			return null;
		}	
	}
}
