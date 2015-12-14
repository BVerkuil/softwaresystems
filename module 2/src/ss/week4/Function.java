package ss.week4;

public interface Function {

	//executes the function to an argument of type double.
	public double apply(double number);
	
	//return Function object that is the derivative of current object.
	public Function derivative();

	//Returns string representation of the function.
	public String toString();
}
