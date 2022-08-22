package cryptography;

/**
 * 
 * @author arohpos
 *
 */

public class Euclid{
	
	/**
	 * @param m メソッドの引数1
	 * @param n メソッドの引数2
	 * @return mとnの最大公約数をintで返す
	 */
	public static int gcd(int m, int n) {
		
		int r = 0;
		
		System.out.println("m:" + m);
		System.out.println("n:" + n);
		
		while(n!=0) {
			
			r = m % n;
			m = n;
			n = r;

		}
		
		System.out.println("最大公約数:" + m);
		
		return m;
		
		
	}
}