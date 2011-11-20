package pl.edu.mimuw.tdd.validator.rules;

import static junit.framework.TestCase.*;

import org.junit.Test;

import pl.edu.mimuw.tdd.validator.rules.Rule;
import pl.edu.mimuw.tdd.validator.rules.RuleNotEmpty;

public class RuleNotEmptyShould {
	
	
	@Test
	public void notAcceptEmptyString() {
		Rule notEmpty = new RuleNotEmpty();
		assertFalse(notEmpty.isValid(""));
	}
	
	@Test
	public void notAcceptWhitespaceString() {
		Rule notEmpty = new RuleNotEmpty();
		assertFalse(notEmpty.isValid("  	  "));
	}
	
	@Test
	public void acceptFilledString() {
		Rule notEmpty = new RuleNotEmpty();
		assertTrue(notEmpty.isValid("abcde"));
	}
}
