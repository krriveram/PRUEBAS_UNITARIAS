
package test;
import static org.junit.Assert.assertEquals;
import org.junit.Test; 


import TallerJUnit.Calculation;


public class CalculationTest {

	@Test
	public void testFindMax() {
		assertEquals(9, Calculation.findMax(new int[] {-2, -3, -10, 9, 5, 7}));
		assertEquals(-1, Calculation.findMax(new int[] {-1, -4, -10, -20, -2, -19}));
		assertEquals(183, Calculation.findMax(new int[] {-1, 4, 50, 183, 90, -255}));
	}
	
}
