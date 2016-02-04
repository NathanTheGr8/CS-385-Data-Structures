package lab01;

public class CipherTest {

	public static void main(String[] args) {
		ClassicalCipher<Integer> cipher = new CaesarCipher(15);
		String stuff = cipher.encyrpt("this is a secret");
		System.out.println(stuff);
		System.out.println(cipher.decrypt(stuff));

		String[] bruteForced = ((CaesarCipher) cipher).bruteForce(stuff);
		for (int i = 0; i < bruteForced.length; i++) {
			System.out.println("Key: " + i + " -> " + bruteForced[i]);
		}
	}

}
