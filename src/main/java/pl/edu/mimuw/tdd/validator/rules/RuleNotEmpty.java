package pl.edu.mimuw.tdd.validator.rules;

import org.apache.commons.lang3.StringUtils;

public class RuleNotEmpty implements Rule {

	@Override
	public boolean isValid(String string) {
		return !StringUtils.isEmpty(StringUtils.trimToEmpty(string));
	}

}
