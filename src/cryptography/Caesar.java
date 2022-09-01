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
	 * shit character multiple times
	 * @param ch			character
	 * @param shift_times	times to use cir_shitt method
	 * @return ch + shift_times mod N
	 */
	
	//chをshift_times分シフトする。
	//今回は小文字のアルファベット内で、循環シフトする。
	public char shift(char ch, int shift_times) {
		
		//0 =< shift_times < N に設定する。 
		//これにより、0未満、N以上の整数に対応する。
		shift_times = shift_times % N;
		
		//本処理
		if(ch != ' ') {
			//スペースはスペースのまま
		}else if(ch != 'z' ) {
			//(char)によりintをcharにキャストすることで、文字コード（UTF-16）に対応した変換をする。
			ch = (char)(ch + shift_times);			
		}else{
			ch = 'a';
		}
		return ch;
	}
	
	/**
	 * encript plaintext into ciphertext by encription key
	 * @param p			plaintext
	 * @param enc_key	encription key
	 * @return c		ciphertext
	 */
	
	/**
	 * generate decription key from encription key
	 * @param enc_key 		encription key
	 * @return dec_key 		decription key
	 */
	
	/**
	 * decript ciphertext into plaintext by decription key
	 * @param c 			ciphertext
	 * @param dec_key 		decription key
	 * @return p 			plaintext
	 */
	
}