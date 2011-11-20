package pl.edu.mimuw.tdd.validator.rules;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class RuleIntegerShould {

	Rule integerRule = null;
	
	@Before
	public void setUp() {
		integerRule = new RuleInteger();
	}
	
	@Test
	public void shouldAcceptEmptyString() {
		assertTrue("RuleInteger odrzuciła pusty string", integerRule.isValid(""));
	}
	
	@Test
	public void notAcceptAlphaString() {
		assertFalse(integerRule.isValid("abcde"));
	}
	
	@Test
	public void notAcceptIntegerWithSpacesInBetween() {
		assertFalse(integerRule.isValid("1245 567 458"));
	}
	
	@Test
	public void acceptInteger() {
		assertTrue(integerRule.isValid("1267"));
	}
	
	@Test
	public void acceptIntegerSurroundedByWhitespace() {
		assertTrue(integerRule.isValid("	  937864	  "));
	}
}
