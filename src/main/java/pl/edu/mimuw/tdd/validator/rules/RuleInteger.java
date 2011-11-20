package pl.edu.mimuw.tdd.validator.rules;

import org.apache.commons.lang3.StringUtils;

public class RuleInteger implements Rule {

	@Override
	public boolean isValid(String string) {
		if(StringUtils.trimToNull(string) == null) return true;
		try {
			Integer.parseInt(StringUtils.trimToEmpty(string));
			return true;
		} catch (NumberFormatException numberFormatException) {
			return false;
		}
	}

}
