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
	private List<Rule> acceptingRules = null;
	private List<Rule> failingRules = null;
	private ComplexRule complexRule = null;
	
	@Before
	public void setUp() {
		complexRule = new ComplexRule();
		acceptingRules = new ArrayList<Rule>();
		for (int i = 0; i < 3; ++i) {
			Rule acceptingRule = mock(Rule.class);
			when(acceptingRule.isValid(anyString())).thenReturn(true);
			acceptingRules.add(acceptingRule);
		}
		failingRules = new ArrayList<Rule>();
		for (int i = 0; i < 3; ++i) {
			Rule failingingRule = mock(Rule.class);
			when(failingingRule.isValid(anyString())).thenReturn(false);
			acceptingRules.add(failingingRule);
		}
		
	}
	
	@Test
	public void allowToAddASubrule() {
		try {
		complexRule.add(acceptingRules.get(0));
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
		ComplexRule complexRule = new ComplexRule();
		addAllRules(complexRule, acceptingRules)
		
		assertTrue(complexRule.isValid(testString));
		for(Rule rule : acceptingRules)
			verify(rule).isValid(testString);
	}

	@Test
	public void notAcceptWhenAnySubruleFails() {
		ComplexRule complexRule = new ComplexRule();
		addAllRules(complexRule, acceptingRules);
		complexRule.add(failingRules.get(0));
		
		assertFalse(complexRule.isValid(testString));
		for(Rule rule : acceptingRules)
			verify(rule).isValid(testString);
		verify(failingRules.get(0)).isValid(testString);
	}
	
	private void addAllRules(ComplexRule complexRule, Collection<Rule> rules) {
		for(Rule rule: rules)
			complexRule.add(rule);
	}

}
