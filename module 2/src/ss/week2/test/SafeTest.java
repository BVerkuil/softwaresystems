package ss.week2.test;

import static org.junit.Assert.*;

import ss.week2.hotel.Safe;
import org.junit.Before;
import org.junit.Test;

public class SafeTest {
	   private Safe s;

	
	@Before
	public void setUp() throws Exception {
		s = new Safe();
	}

	@Test
	public void testActivateCorrectPassword() {
		s.activate("pwoord");
		assertTrue(s.isActive());
	}

	@Test
	public void testActivateCorrectWrongPassword() {
		s.activate("adnasdasd");
		assertFalse(s.isActive());
	}
	
	@Test
	public void testOpenCorrectPassword() {
		s.activate("pwoord");
		s.open("pwoord");
		assertTrue(s.isOpen());
	}
	
	@Test
	public void testOpenWrongPassword() {
		s.activate("pwoord");
		s.open("pwooasdasrd");
		assertFalse(s.isOpen());
	}
	
	@Test
	public void testDeactivate() {
		s.activate("pwoord");
		s.deactivate();
		assertFalse(s.isActive());
	}
	
/*	@Test
	public void testGetPassword() {
		assertEquals("pwoord", s.getPasssword());
	}
*/
}
