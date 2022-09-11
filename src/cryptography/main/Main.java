package cryptography.main;

import java.util.Scanner;

import cryptography.main.caesar.Caesar;
import cryptography.main.euclid.Euclid;

public class Main{
	
	public static void main(String[] args) {
		
		System.out.println("Hello, world");
				
		Euclid euclid = new Euclid();
		
		euclid.gcd(3, 1);		
		
		euclid.extgcd(100, 35);
	
		do_caesar();
	}
	
	public static void do_caesar() {
		
		Scanner input_mode =  new Scanner(System.in);
		
		System.out.println("Which procedure do you want?");
		System.out.println("Type 1 (encription) or 2 (decription)");
		
		int mode = input_mode.nextInt();
		//ここでcloseしてしまうと、System.inの使用をやめてしまう。
		//input_mode.close();
		if (mode == 1) {
			do_enc();
		}else {
			do_dec();
		}
	}
	
	public static void do_enc() {
		
		Caesar caesar = new Caesar();
		Scanner scanner =  new Scanner(System.in);
		
		//input plaintext
		System.out.println("Type plaintext, just using small letter like abc not like ABC.");
		String p = scanner.nextLine();
		System.out.println("Your plaintext is following:" + p);
		
		//input encription key
		System.out.println("Type encription key in integer.");
		int enc_key = scanner.nextInt();
		//特に必要ないためcloseしない
		//scanner.close();
		System.out.println("Your encription key is following:" + enc_key);
		
		//generate decription key
		System.out.println("Your decriptin key is following:" + caesar.gen_key(enc_key));
		System.out.println("Don't foget this decription key, which is used for decription.");
		
		//generate ciphertext
		String c = caesar.enc(p, enc_key);
		System.out.println("Your ciphertext is following;" + c);
		
		//finish procedure
		System.out.println("Encription procedure is finished.");
		
	}
	
	public static void do_dec() {
		
		Caesar caesar = new Caesar();
		Scanner scanner =  new Scanner(System.in);
		
		//input plaintext
		System.out.println("Type chipertext, just using small letter like abc not like ABC.");
		String c = scanner.nextLine();
		System.out.println("Your chiphertext is following:" + c);
		
		//input encription key
		System.out.println("Type decription key in integer.");
		int dec_key = scanner.nextInt();
		//特に必要ないためcloseしない
		//scanner.close();
		System.out.println("Your decription key is following:" + dec_key);
		
		//generate plaintext
		String p = caesar.dec(c, dec_key);
		System.out.println("Your plaintext is following;" + p);
		
		//finish procedure
		System.out.println("Decription procedure is finished.");
	}
}
