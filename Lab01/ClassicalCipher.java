package lab01;

public abstract class ClassicalCipher<keyType> {
	private String upperAlpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private String lowerAlpha = upperAlpha.toLowerCase();;
	protected keyType key;

	public ClassicalCipher(keyType key) {
		this.key = key;
	}
	
	public abstract String encyrpt (String plainText);
	public abstract String decrypt (String cipherText);

	public String getUpperAlpha() {
		return upperAlpha;
	}

	public String getLowerAlpha() {
		return lowerAlpha;
	}

	public keyType getKey() {
		return key;
	}
	
	
	
}
