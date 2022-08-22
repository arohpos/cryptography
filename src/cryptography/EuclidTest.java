package cryptography;


import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 * @author arohpos
 *
 */

public class EuclidTest{
	
	@Test
	public void testGcd() {
		Euclid euclid = new Euclid();
		
		assertEquals(3, euclid.gcd(12, 15));
		
	}
}