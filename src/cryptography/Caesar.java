package cryptography;

/**
 * 
 * @author arohpos
 *
 */

public class Caesar{
	
	int mode = 1;
	int N = 26;
	
	/* Want:
	 * 現状はアルファベットは一般的なアルファベット（A, B, C, ..., Z）とする。（mode1）
	 * いずれは、アルファベットの種類を増やし、選択したmodeによって変換方式が変更されるように実装する。
	 */
	
	/**
	 * shit character multiple once
	 * @param ch			character
	 * @return ch + 1 mod N
	 */
	
	//chを1回分シフトする。
	//今回は小文字のアルファベット内で、循環シフトする。
	public char shift_once(char ch) {
		
		//本処理
		if(ch == ' ') {
			//スペースはスペースのまま
		}else if(ch != 'z' ) {
			//(char)によりintをcharにキャストすることで、文字コード（UTF-16）に対応した変換をする。
			ch = (char)(ch + 1);			
		}else{
			ch = 'a';
		}
		return ch;
	}
	
	/**
	 * shit character multiple once
	 * @param ch			character
	 * @param times			time to shift
	 * @return ch + times mod N
	 */
	
	public char shift_times(char ch, int times) {
		
		//0 =< shift_times < N に設定する。 
		//これにより、0未満、N以上の整数に対応する。
		times = Math.floorMod(times, N);
		
		Caesar caesar = new Caesar();
		boolean isEnd = false;
		int i = 0;
		
		while(isEnd == false) {
			
			ch = caesar.shift_once(ch);
			i = i+1; 
			
			if(i == times) {
				isEnd =true;
			}
			
		}
		
		return ch;
		
	}
	
	/**
	 * encript plaintext into ciphertext by encription key
	 * @param p			plaintext
	 * @param enc_key	encription key
	 * @return c		ciphertext
	 */
	
	public String enc(String p, int enc_key) {
		
		//charのループ内での結合のため、StringBuilderを使用
		StringBuilder c = new StringBuilder();
		Caesar caesar = new Caesar();
		
		for(int i = 0; i < p.length(); i++) {
			
			//String pのi番目の文字を取得し、enc_keyをもとにずらして、appendしていく。
			c.append(caesar.shift_times(p.charAt(i), enc_key));
			
		}
		
		//cはStringBuilder型のため、toStringメソッドを用いてStringへ型変換する。
		return c.toString();
	}
	
	/**
	 * generate decription key from encription key
	 * @param enc_key 		encription key
	 * @return dec_key 		decription key
	 */
	
	public int gen_key(int enc_key) {
		
		//シーザー暗号の場合、復号鍵は暗号鍵の符号を逆転させたものである。
		return -enc_key;
		
	}
	
	/**
	 * decript ciphertext into plaintext by decription key
	 * @param c 			ciphertext
	 * @param dec_key 		decription key
	 * @return p 			plaintext
	 */
	
	public String dec(String c, int dec_key) {
		
		Caesar caesar = new Caesar();
		
		//シーザー暗号の場合復号化関数は、本質的に暗号化関数と同じため、同じ関数を用いる。
		return caesar.enc(c, dec_key);
	}
	
}