package pl.edu.mimuw.tdd.validator.rules.pesel;

import java.util.Arrays;

import pl.edu.mimuw.tdd.validator.rules.Rule;

public class RulePeselDate implements Rule {

	@Override
	public boolean isValid(String string) {
		//if(Arrays.asList(new char[] {'0', '2', '4', '6', '8'}).contains(string.charAt(0)));
		return false;
	}

}
