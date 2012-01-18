package pl.edu.mimuw.tdd.validator.rules.pesel;

import static org.junit.Assert.*;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class RulePeselDateShould {

	RulePeselDate rulePeselDate = null;
	
	@Before
	public void setUp() {
		rulePeselDate = new RulePeselDate();
	}
	
	@Test
	public void failSilentlyWithTooShortString() {
		try {
			assertFalse(rulePeselDate.isValid("ab"));
		} catch (Exception e) {
			fail("RulePeselDate#isValid thrown an exception when invoked with too short string");
		}
	}
	
	@Test
	@Parameters({"50100579261", "99873182095", "47090928186"})
	public void testProperDate(String pesel) {
		assertTrue(rulePeselDate.isValid(pesel));
	}
	
	@Test
	public void testMonthOutOfRangeOddAndGreaterThanTwo1() {
		assertFalse(rulePeselDate.isValid("26330585729"));
	}

	@Test
	public void testMonthOutOfRangeOddAndGreaterThanTwo2() {
		assertFalse(rulePeselDate.isValid("36140597258"));
	}
	
	@Test
	public void testMonthOutOfRangeEvenAndZero() {
		assertFalse(rulePeselDate.isValid("36400597258"));
	}
	
	@Test
	public void testDayOutOfRangeAprilThirtyFirst() {
		assertFalse(rulePeselDate.isValid("14043182083"));
	}
	
	@Test
	public void testDayOutOfRangeForty() {
		assertFalse(rulePeselDate.isValid("14864002783"));
	}
	
	@Test
	public void testDayOutOfRangeFebruaryThirty() {
		assertFalse(rulePeselDate.isValid("12423072935"));
	}
}