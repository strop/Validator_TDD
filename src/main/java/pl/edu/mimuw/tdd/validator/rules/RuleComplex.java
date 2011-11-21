package pl.edu.mimuw.tdd.validator.rules;

import java.util.ArrayList;
import java.util.List;

public class RuleComplex implements Rule {

	List<Rule> rules = new ArrayList<Rule>();

	@Override
	public boolean isValid(String string) {
		for (Rule rule : rules)
			if (!rule.isValid(string))
				return false;
		return true;
	}

	public void add(Rule rule) {
		rules.add(rule);
	}

}