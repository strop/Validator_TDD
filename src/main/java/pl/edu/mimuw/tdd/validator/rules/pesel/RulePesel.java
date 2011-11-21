package pl.edu.mimuw.tdd.validator.rules.pesel;

import pl.edu.mimuw.tdd.validator.rules.RuleComplex;
import pl.edu.mimuw.tdd.validator.rules.RuleExactCharLength;
import pl.edu.mimuw.tdd.validator.rules.RuleInteger;
import pl.edu.mimuw.tdd.validator.rules.RuleNotEmpty;

public class RulePesel extends RuleComplex {
	
	public RulePesel() {
		add(new RuleNotEmpty());
		add(new RuleInteger());
		add(new RuleExactCharLength(11));
		
	}
}
