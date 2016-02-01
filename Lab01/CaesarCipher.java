package Lab01;

public class CaesarCipher extends ClassicalCipher<Integer> {

	public CaesarCipher(Integer key) {
		super(key);
	}

	@Override
	public String encyrpt(String plainText) {
		String cipherText = "";
		int curr;
		char plainLetter;
		char cipherLetter;
		for (int i = 0; i < plainText.length(); i++) {
			plainLetter = plainText.charAt(i);
			if (getLowerAlpha().contains(plainLetter + "") || getUpperAlpha().contains(plainLetter + "")) {
				if (Character.isUpperCase(plainLetter)) {
					curr = (getUpperAlpha().indexOf(plainLetter) + key) % getUpperAlpha().length();
					cipherLetter = getUpperAlpha().charAt(curr);
				} else {
					curr = (getLowerAlpha().indexOf(plainLetter) + key) % getLowerAlpha().length();
					cipherLetter = getLowerAlpha().charAt(curr);
				}
				cipherText += cipherLetter;
			}
		}
		return cipherText;
	}

	@Override
	public String decrypt(String cipherText) {
		String plainText = "";
		int curr;
		char plainLetter;
		char cipherLetter;
		for (int i = 0; i < cipherText.length(); i++) {
			cipherLetter = cipherText.charAt(i);
			if (getLowerAlpha().contains(cipherLetter + "") || getUpperAlpha().contains(cipherLetter + "")) {
				if (Character.isUpperCase(cipherLetter)) {
					curr = (getUpperAlpha().indexOf(cipherLetter) - key) % getUpperAlpha().length();
					if (curr < 0)
						curr += getUpperAlpha().length();
					plainLetter = getUpperAlpha().charAt(curr);

				} else {
					curr = (getLowerAlpha().indexOf(cipherLetter) - key) % getLowerAlpha().length();
					if (curr < 0)
						curr += getLowerAlpha().length();
					plainLetter = getLowerAlpha().charAt(curr);
				}
				plainText += plainLetter;
			}
		}
		return plainText;
	}

	public String[] bruteForce(String cipherText) {
		int keyTemp = key;
		String[] results = new String[getUpperAlpha().length()];

		for (int k = 0; k < getUpperAlpha().length(); k++) {
			key = k;
			results[k] = decrypt(cipherText);
		}
		return results;
	}

}
