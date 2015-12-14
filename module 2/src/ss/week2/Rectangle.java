package ss.week2;


public class Rectangle {
	
	private int length;
	private int width;

	//@ invariant length >= 0;
	//@ invariant width >= 0;
	
	//@ requires length >= 0;
	//@ requires width >= 0;
	//@ ensures length() = length;
	//@ ensures width() = width;
	public Rectangle(int length, int width) { 
		assert length >= 0;
		assert width >= 0;
		this.length = length;
		this.width = width;	
	}

	//@ ensures \result >= 0;
	/*@pure */public int length() {
		return length;			
	}
	//@ ensures \result >= 0;
	/*@pure */public int width() {
		return width;
	}
	//@ ensures \result >= 0 && \result == (length() * width());
	/*@pure */public int area() {
		return length * width;
	}
	//@ ensures \result >= 0 && \result == (2 * width() + 2 * width());
	//@ requires width() >= 0;
	//@ requires length() >= 0;
	public int perimeter() {
		return (2 * width) + (2 * length);
	}
}
