package cryptography.test.euclid;


import static org.junit.Assert.*;

import org.junit.Test;

import cryptography.main.euclid.Euclid;

/**
 * 
 * @author arohpos
 *
 */

public class EuclidTest{
	
	int a = 100;
	int b = 35;
	
	//最大公約数が正しく求まるか
	@Test
	public void testGcd() {
		Euclid euclid = new Euclid();
		
		assertEquals(5, euclid.gcd(a, b));
		
	}

	//(a, b)に対してax * by = gcd(a, b)をみたすxが正しく求まるか
	@Test
	public void testExtgcdSol1() {
		Euclid euclid = new Euclid();
		
		assertEquals(-1, euclid.extgcd(a, b)[0]);
		
	}
	
	//(a, b)に対してax * by = gcd(a, b)をみたすyが正しく求まるか
	@Test
	public void testExtgcdSol2() {
		Euclid euclid = new Euclid();
		
		assertEquals(3, euclid.extgcd(a, b)[1]);
		
	}
	
	//(a, b)に対してax * by = gcd(a, b)をみたす(x, y)を計算し、正しく等式が満たされるか
	@Test
	public void testExtgcdEq() {
		Euclid euclid = new Euclid();
		
		assertEquals(euclid.gcd(a, b), a * euclid.extgcd(a, b)[0] + b * euclid.extgcd(a, b)[1]);
		
	}
	
}