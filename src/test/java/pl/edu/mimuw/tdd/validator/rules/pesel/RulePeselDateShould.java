package pl.edu.mimuw.tdd.validator.rules.pesel;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

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
	public void testProperOne() {
		assertTrue(rulePeselDate.isValid("50100579261"));
	}
	
	@Test
	public void testProperTwo() {
		assertTrue(rulePeselDate.isValid("99873182095"));
	}
	
	@Test
	public void testProperThree() {
		assertTrue(rulePeselDate.isValid("47090928186"));
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