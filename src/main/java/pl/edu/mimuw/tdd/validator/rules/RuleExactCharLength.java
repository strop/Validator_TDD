package pl.edu.mimuw.tdd.validator.rules;

import org.apache.commons.lang3.StringUtils;

public class RuleExactCharLength implements Rule {

	private int expectedLength = 0;
	
	public RuleExactCharLength(int expectedLength) {
		this.expectedLength = expectedLength;
	}

	@Override
	public boolean isValid(String string) {
		return StringUtils.length(string) == expectedLength;
	}

}