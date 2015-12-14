package ss.week4.test;

import org.junit.Before;
import org.junit.Test;
import ss.week4.Sum;
import ss.week4.Polynomial;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class PolynomialTest {

	private Polynomial testPolynomial;
    private static final double DELTA = 1e-15;
	
	@Before
    public void setUp() {
        testPolynomial = new Polynomial(new double[]{3,1});
        }
	
	@Test
	public void testApply() {
		 assertEquals(4, testPolynomial.apply(1), DELTA);
		 assertEquals(6, testPolynomial.apply(3), DELTA);
	}
	
	@Test
	public void  testDerivative() {
		System.out.println(testPolynomial.derivative());
		
		assertTrue(testPolynomial.derivative() instanceof Sum);
        assertEquals(1 , testPolynomial.derivative().apply(3), DELTA);
	}
	
	@Test
	public void  testIntegrand() {
		assertTrue(testPolynomial.integrand() instanceof Sum);
        assertEquals(24 , testPolynomial.integrand().apply(8), DELTA);
	}
}
