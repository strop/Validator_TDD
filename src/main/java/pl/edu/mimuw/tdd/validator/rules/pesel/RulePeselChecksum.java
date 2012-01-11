package pl.edu.mimuw.tdd.validator.rules.pesel;

import pl.edu.mimuw.tdd.validator.rules.Rule;

public class RulePeselChecksum implements Rule {

	@Override
	public boolean isValid(String string) {
		try {
			int[] coefficients = new int[] { 1, 3, 7, 9 };
			int sum = 0;
			for (int i = 0; i < 10; ++i)
				sum += charToDigit(string.charAt(i)) * coefficients[i % 4];
			sum += charToDigit(string.charAt(10));
			return (sum % 10) == 0;
		} catch (IndexOutOfBoundsException outOfBoundsException) {
			return false;
		}
	}

	private int charToDigit(char character) {
		return Character.digit(character, 10);
	}

}
