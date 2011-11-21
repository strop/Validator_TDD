package pl.edu.mimuw.tdd.validator.validators;

import java.util.ArrayList;
import java.util.List;

import pl.edu.mimuw.tdd.validator.forms.HasText;
import pl.edu.mimuw.tdd.validator.rules.Rule;

public class FieldValidator {

	List<Rule> rules = new ArrayList<Rule>();
	HasText field = null;

	public void addRule(Rule rule) {
		rules.add(rule);
	}

	public boolean isValid() {
		for (Rule rule : rules)
			if (!rule.isValid(field.getText()))
				return false;
		return true;
	}

	public void setField(HasText field) {
		this.field = field;
	}

}