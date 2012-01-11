package pl.edu.mimuw.tdd.validator.rules.pesel;

import pl.edu.mimuw.tdd.validator.rules.Rule;

public class RulePeselDate implements Rule {

	@Override
	public boolean isValid(String string) {
		try {
			int monthFirst = charToDigit(string.charAt(2));
			int monthSecond = charToDigit(string.charAt(3));
			int dayFirst = charToDigit(string.charAt(4));
			int daySecond = charToDigit(string.charAt(5));
			int day = dayFirst * 10 + daySecond;
			if (!even(monthFirst))
				if (monthSecond > 2)
					return false;
			if (even(monthFirst))
				if (monthSecond == 0)
					return false;
			if (day == 0)
				return false;

			if (!even(monthFirst + monthSecond) || monthSecond == 8) {
				if (day > 31)
					return false;
			} else
				if(monthSecond == 2) {
					if(day > 29) return false;
				} else if (day > 30) return false;
			
			return true;
		} catch (IndexOutOfBoundsException outOfBoundsException) {
			return false;
		}
	}

	private int charToDigit(char character) {
		return Character.digit(character, 10);
	}

	private boolean even(int number) {
		return number % 2 == 0;
	}

}
