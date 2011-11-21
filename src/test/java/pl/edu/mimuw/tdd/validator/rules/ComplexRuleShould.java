package pl.edu.mimuw.tdd.validator.rules;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ComplexRuleShould {

	private static final String testString = "some text";
	private Collection<Rule> acceptingRules = null;
	private Collection<Rule> failingRules = null;
	private RuleComplex complexRule = null;

	@Before
	public void setUp() {
		complexRule = new RuleComplex();
		acceptingRules = RuleTestFactory.createAcceptingRules(3);
		failingRules = RuleTestFactory.createFailingRules(3);
	}

	@Test
	public void allowToAddASubrule() {
		try {
			complexRule.add(RuleTestFactory.createFailingRule());
		} catch (Exception e) {
			fail("ComplexRule#add threw an exception.");
		}
	}

	@Test
	public void acceptWithoutAddedRules() {
		assertTrue(complexRule.isValid(testString));
	}

	@Test
	public void acceptWhenAllSubrulesAccept() {
		addAllRules(complexRule, acceptingRules);

		assertTrue(complexRule.isValid(testString));
		for (Rule rule : acceptingRules)
			verify(rule).isValid(testString);
	}

	@Test
	public void notAcceptWhenAnySubruleFails() {
		addAllRules(complexRule, acceptingRules);
		Rule failingRule = RuleTestFactory.createFailingRule();
		complexRule.add(failingRule);

		assertFalse(complexRule.isValid(testString));
		verify(failingRule).isValid(testString);
	}

	private void addAllRules(RuleComplex complexRule, Collection<Rule> rules) {
		for (Rule rule : rules)
			complexRule.add(rule);
	}

}