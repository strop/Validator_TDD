package pl.edu.mimuw.tdd.validator.validators;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import pl.edu.mimuw.tdd.validator.rules.RuleTestFactory;

public class FormValidatorShould {

	public FormValidator formValidator = null;

	@Before
	public void setUp() throws Exception {
		formValidator = new FormValidator();
	}

	@Test
	public void allowAddingAField() {
		try {
			formValidator.addField(FieldValidatorTestFactory.createFailingFieldValidator());
		} catch (Exception e) {
			fail("FormValidator#addField threw an exception.");
		}
	}

	@Test
	public void acceptWhenAllFieldsAccept() {
		Collection<FieldValidator> fields = FieldValidatorTestFactory.createAcceptingFieldValidators(5);
		addAllFields(formValidator, fields);
		assertTrue(formValidator.isValid());
	}
	
	@Test
	public void notAcceptWhenAnyFieldFails() {
		Collection<FieldValidator> fields = FieldValidatorTestFactory.createAcceptingFieldValidators(5);
		addAllFields(formValidator, fields);
		formValidator.addField(FieldValidatorTestFactory.createFailingFieldValidator());
		assertFalse(formValidator.isValid());
	}

	@Test
	public void checkHisFields() {
		Collection<FieldValidator> fields = FieldValidatorTestFactory.createAcceptingFieldValidators(5);
		addAllFields(formValidator, fields);
		formValidator.isValid();
		for (FieldValidator field : fields)
			verify(field).isValid();
	}
	
	private void addAllFields(FormValidator formValidator, Collection<FieldValidator> fields) {
		for(FieldValidator field : fields) 
			formValidator.addField(field);
	}

}