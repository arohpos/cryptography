package cryptography.main.euclid;

/**
 * 
 * @author arohpos
 *https://qiita.com/drken/items/b97ff231e43bce50199a
 */

public class Euclid{
	
	/**
	 * 整数組（a, b）の最大公約数を返す。
	 * @param a 
	 * @param b 
	 * @return aとbの最大公約数
	 */
	public int getGcdFor(int a, int b) {
		//ユークリッドの互徐法を用いる。
		if(b == 0) {
			return a;
		}else {
			//Thm.2.8.1: If b != 0, then gcd(a, b) = gcd(b, a mod b).
			return getGcdFor(b, a % b);
		}
	}
	
	/**
	 * 整数組(a, b)により定まる一次不定方程式ax + by = gcd(a, b)の解（ベズー係数）を返す。
	 * @param a
	 * @param b
	 * @return ax + by = gcd(a, b)を満たす整数組(x, y)
	 */
	
	public int[] getBezoutCoefficientFor(int a, int b) {
		
		//拡張ユークリッドアルゴリズムを用いる。
		
		
		System.out.println("a = " + a + "、 b = " + b + "に対して、");
		System.out.println("a * x + b * y = gcd(a, b)をみたす(x, y)をもとめる。");
		//問題をより小さい問題に帰着できることを記載する。
		
		
		
		
		//2つの解を配列を用いて戻り値とする	
		int[] sols = new int[2];
		
		sols[0] = 1;
		sols[1] = 2;
		
		int x_0 = 1;
		int x_1 = 0;
		int y_0 = 0;
		int y_1 = 1;
		int r_0 = a;
		int r_1 = b;
		
		int sign = 1;
		
		System.out.println("t:\tx_t\ty_t\tq_t\tr_t");
		System.out.println("0:\t1 \t0\t-\t" + a);
		System.out.println("1:\t0\t1\t-\t" + b);
		
		//ループ数t（t=0, 1のケースはすでに出力されているため、t=2とする。）
		int index = 2;
		
		boolean isEnd = false;
		
		while(isEnd == false) {
			
			int q = r_0 / r_1;
			int r_2 = r_0 % r_1;
			int x_2 = x_0 + q * x_1;
			int y_2 = y_0 + q * y_1;
			
			System.out.println(index + ":\t" + x_2 + "\t" + y_2 + "\t" + q + "\t" + r_2);
			
			//r_tの更新（r_0が割られる数、r_1が割る数)
			r_0 = r_1;
			r_1 = r_2;
			
			//x_tとy_tの更新
			x_0 = x_1;
			x_1 = x_2;
			y_0 = y_1;
			y_1 = y_2;
			
			
			//ループ終了条件
			if(r_2 == 0) {
				
				isEnd = true;	
				
			}
			
			//ループ数更新
			index = index + 1;
			
			//正負入替え
			sign = -sign;
			
		}
		
		//解
		sols[0] = sign * x_0;
		sols[1] = -sign * y_0;
				
		System.out.print("以上の整理より、x = " + sols[0] + "、 y = " + sols[1]+ "のとき、");
		System.out.println(a + " * " + sols[0] + " + " + b + " * " + sols[1]+ " = gcd(a, b)を満たす。");
		
		return sols;
	}
}