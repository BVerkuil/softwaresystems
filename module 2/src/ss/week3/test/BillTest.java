package ss.week3.test;

import ss.week3.hotel.Bill;
import ss.week3.hotel.SimpleItem;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BillTest {

	private Bill newbill;
	private SimpleItem newitem;
	private SimpleItem newitem2;
	
	@Before
	public void setUp() {
			newbill = new Bill(null);
			newitem = new SimpleItem("Cola", 0.32);
			newitem2 = new SimpleItem("Fanta", 0.32);
	}
	
	
	@Test
	public void testGetAmount() throws Exception {
		assertEquals("The Sum should be updated", newitem.getAmount(), 0.32,0);
	}
	@Test
	public void testGetString() {
		assertEquals("The string should be upated", newitem.toString(), "Cola");
	}
	
	@Test
	public void testGetNewItem() {
		newbill.newItem(newitem);
		newbill.newItem(newitem2);
		assertEquals("The sum should be upated", newbill.getSum(), 0.64, 0);
		
	}
} 
