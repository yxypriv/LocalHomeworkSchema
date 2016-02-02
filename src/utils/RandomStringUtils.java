package utils;

import java.util.Random;

public class RandomStringUtils {
	int min_length = 3;
	int max_length = 10;
	public static final String uppercaseChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String lowercaseChar = "abcdefghijklmnopqrstuvwxyz";
	public static final String numberChar = "0123456789";

	String charactorOptions = uppercaseChar + lowercaseChar + numberChar;

	public void setLengthRange(int min, int max) {
		min_length = min;
		max_length = max;
	}

	public void setCharactorOptions(String option) {
		charactorOptions = option;
	}

	Random rand = new Random();

	public String nextRandomString() {
		StringBuilder sb = new StringBuilder();
		int length = rand.nextInt(max_length - min_length + 1) + min_length;
		for (int i = 0; i < length; i++) {
			int randomIndex = rand.nextInt(charactorOptions.length());
			sb.append(charactorOptions.charAt(randomIndex));
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		RandomStringUtils randomString = new RandomStringUtils();
		for (int i = 0; i < 100; i++) {
			String nextRandomString = randomString.nextRandomString();
			System.out.println(nextRandomString);
		}
	}
}
