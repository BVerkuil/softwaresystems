package ss.week2;



import ss.week2.Rectangle;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;

public class RectangleTest {
	
	private Rectangle klein;
	
	@Before
    public void setUp() {
		klein = new Rectangle(4,8);
    }
	
	@Test
	public void testInitialcondition() {
        assertEquals(32, klein.area());
        assertEquals(8, klein.width());
        assertEquals(4, klein.length());
        assertEquals(24, klein.perimeter());
	}
}
