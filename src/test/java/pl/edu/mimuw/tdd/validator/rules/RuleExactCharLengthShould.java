package pl.edu.mimuw.tdd.validator.rules;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class RuleExactCharLengthShould {

	Rule exactCharLengthRule = null;

	@Before
	public void setUp() {
	}

	@Test
	public void notAcceptLonger() {
		exactCharLengthRule = new RuleExactCharLength(10);
		assertFalse(exactCharLengthRule.isValid("12345678901"));
	}
	
	@Test
	public void notAcceptShorter() {
		exactCharLengthRule = new RuleExactCharLength(10);
		assertFalse(exactCharLengthRule.isValid("12345"));
	}
	
	@Test
	public void acceptStringOfExactLength() {
		exactCharLengthRule = new RuleExactCharLength(10);
		assertTrue(exactCharLengthRule.isValid("1234567890"));
	}
	
}
