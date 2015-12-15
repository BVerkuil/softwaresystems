package ss.week6;

public class ArgumentLengthsDifferException extends TooFewArgumentsException{
	public ArgumentLengthsDifferException() {
	}
	public ArgumentLengthsDifferException(int a, int b) {
		super("error: length of command line arguments "
                + "differs (" + a + ", " + b + ")");
	}
}
