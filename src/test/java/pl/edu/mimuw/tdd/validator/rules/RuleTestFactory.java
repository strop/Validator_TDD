package pl.edu.mimuw.tdd.validator.rules;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RuleTestFactory {

	public static Rule createAcceptingRule() {
		return createRule(true);
	}

	public static Rule createFailingRule() {
		return createRule(false);
	}

	private static Rule createRule(boolean accepting) {
		Rule rule = mock(Rule.class);
		when(rule.isValid(anyString())).thenReturn(accepting);
		return rule;
	}

	public static Collection<Rule> createAcceptingRules(int count) {
		return createRules(count, true);
	}

	public static Collection<Rule> createFailingRules(int count) {
		return createRules(count, false);
	}

	private static Collection<Rule> createRules(int count, boolean accepting) {
		List<Rule> rules = new ArrayList<Rule>();
		for (int i = 0; i < 3; ++i)
			rules.add(createRule(accepting));
		return rules;
	}
}