package cryptography;

public class Main{
	
	public static void main(String[] args) {
		
		System.out.println("Hello, world");
				
		Euclid euclid = new Euclid();
		
		euclid.gcd(3, 1);		
		
		euclid.extgcd(100, 35);

	}
}
