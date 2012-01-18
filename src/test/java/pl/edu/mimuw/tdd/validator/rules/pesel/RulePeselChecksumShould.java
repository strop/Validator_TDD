package pl.edu.mimuw.tdd.validator.rules.pesel;

import static org.junit.Assert.*;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
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
	@Parameters({"47090928186", "50100579263", "99873182098", "00000000000"})
	public void testProperChecksum(String pesel) {
		assertTrue(rulePeselChecksum.isValid(pesel));
	}

	@Test
	@Parameters({"36140597251", "36400597258", "14043182083", "14864002783"})
	public void testWrongChecksum(String pesel) {
		assertFalse(rulePeselChecksum.isValid(pesel));
	}
	
}