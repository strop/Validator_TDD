package pl.edu.mimuw.tdd.validator.validators;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import pl.edu.mimuw.tdd.validator.forms.HasText;
import pl.edu.mimuw.tdd.validator.rules.Rule;
import pl.edu.mimuw.tdd.validator.rules.RuleTestFactory;

public class FieldValidatorShould {

	public static final String testString = "some_text";

	private FieldValidator fieldValidator = null;

	@Before
	public void setUp() {
		fieldValidator = new FieldValidator();
	}

	@Test
	public void allowToAddRule() {
		try {
			fieldValidator.addRule(RuleTestFactory.createFailingRule());
		} catch (Exception e) {
			fail("FieldValidator#addRule threw an exception.");
		}
	}

	@Test
	public void allowToSetField() {
		try {
			fieldValidator.setField(mock(HasText.class));
		} catch (Exception e) {
			fail("FieldValidator#setField threw an exception.");
		}
	}

	@Test
	public void acceptWhenAllRulesAccept() {
		fieldValidator.setField(mock(HasText.class));
		Collection<Rule> acceptingRules = RuleTestFactory.createAcceptingRules(3);
		for (Rule rule : acceptingRules)
			fieldValidator.addRule(rule);
		assertTrue(fieldValidator.isValid());
	}

	@Test
	public void testAgainstHisFieldText() {
		HasText stubField = mock(HasText.class);
		when(stubField.getText()).thenReturn(testString);
		fieldValidator.setField(stubField);
		Collection<Rule> acceptingRules = RuleTestFactory.createAcceptingRules(3);
		for (Rule rule : acceptingRules)
			fieldValidator.addRule(rule);
		fieldValidator.isValid();
		for (Rule rule : acceptingRules)
			verify(rule).isValid(testString);
	}

	@Test
	public void notAcceptWhenAnyRuleFails() {
		fieldValidator.setField(mock(HasText.class));
		Collection<Rule> acceptingRules = RuleTestFactory.createAcceptingRules(3);
		Collection<Rule> failingRules = RuleTestFactory.createFailingRules(3);
		for (Rule rule : acceptingRules)
			fieldValidator.addRule(rule);
		for (Rule rule : failingRules)
			fieldValidator.addRule(rule);
		assertFalse(fieldValidator.isValid());
	}
}
