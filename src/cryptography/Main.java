package cryptography;

public class Main{
	
	public static void main(String[] args) {
		
		System.out.println("Hello, world");
				
		Euclid euclid = new Euclid();
		
		euclid.gcd(3, 1);		
		
		euclid.extgcd(100, 35);
	
		do_enc();
		do_dec();
	}
	
	public static void do_enc() {
		
		Caesar caesar = new Caesar();
		
		//input plaintext
		System.out.println("Type plaintext, just using small letter like abc not like ABC.");
		String p = "hello";
		System.out.println("Your plaintext is following:");
		System.out.println(p);
		
		//input encription key
		System.out.println("Type encription key in integer.");
		int enc_key = 1;
		System.out.println("Your encription key is following:");
		System.out.println(enc_key);
		
		//generate decription key
		System.out.println("Your decriptin key is following:");
		System.out.println(caesar.gen_key(enc_key));		
		System.out.println("Don't foget this decription key, which is used for decription.");
		
		//generate ciphertext
		String c = caesar.enc(p, enc_key);
		System.out.println("Your ciphertext is following;");
		System.out.println(c);
		
	}
	
	public static void do_dec() {
		
		Caesar caesar = new Caesar();
		
		//input plaintext
		System.out.println("Type chipertext, just using small letter like abc not like ABC.");
		String c = "ifmmp";
		System.out.println("Your chiphertext is following:");
		System.out.println(c);
		
		//input encription key
		System.out.println("Type decription key in integer.");
		int dec_key = -1;
		System.out.println("Your decription key is following:");
		System.out.println(dec_key);
		
		//generate plaintext
		String p = caesar.dec(c, dec_key);
		System.out.println("Your plaintext is following;");
		System.out.println(p);
		
	}
}
