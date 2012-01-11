package pl.edu.mimuw.tdd.validator.rules.pesel;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RulePeselChecksumShould {

	RulePeselChecksum rulePeselChecksum = null;
	
	@Before
	public void setUp() {
		rulePeselChecksum = new RulePeselChecksum();
	}
	
	@Test
	public void failSilentlyWithTooShortString() {
		try {
			assertFalse(rulePeselChecksum.isValid("ab"));
		} catch (Exception e) {
			fail("RulePeselChecksum#isValid thrown an exception when invoked with too short string");
		}
	}
	
	@Test
	public void testProperOne() {
		assertTrue(rulePeselChecksum.isValid("50100579263"));
	}
	
	@Test
	public void testProperTwo() {
		assertTrue(rulePeselChecksum.isValid("99873182098"));
	}
	
	@Test
	public void testProperThree() {
		assertTrue(rulePeselChecksum.isValid("47090928186"));
	}
	
	@Test
	public void testProperFour() {
		assertTrue(rulePeselChecksum.isValid("00000000000"));
	}

	@Test
	public void testWrongOne() {
		assertFalse(rulePeselChecksum.isValid("36140597251"));
	}
	
	@Test
	public void testWrongTwo() {
		assertFalse(rulePeselChecksum.isValid("36400597258"));
	}
	
	@Test
	public void testWrongThree() {
		assertFalse(rulePeselChecksum.isValid("14043182083"));
	}
	
	@Test
	public void testWrongFour() {
		assertFalse(rulePeselChecksum.isValid("14864002783"));
	}
	
}