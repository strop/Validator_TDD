package pl.edu.mimuw.tdd.validator.validators;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FieldValidatorTestFactory {

	public static FieldValidator createAcceptingFieldValidator() {
		return createFieldValidator(false);
	}

	public static FieldValidator createFailingFieldValidator() {
		return createFieldValidator(false);
	}

	private static FieldValidator createFieldValidator(boolean accepting) {
		FieldValidator fieldValidator = mock(FieldValidator.class);
		when(fieldValidator.isValid()).thenReturn(accepting);
		return fieldValidator;
	}

	public static Collection<FieldValidator> createAcceptingFieldValidators(int count) {
		return createFieldValidators(count, true);
	}

	public static Collection<FieldValidator> createFailingFieldValidators(int count) {
		return createFieldValidators(count, false);
	}

	private static Collection<FieldValidator> createFieldValidators(int count, boolean accepting) {
		List<FieldValidator> fieldValidators = new ArrayList<FieldValidator>();
		for (int i = 0; i < 3; ++i)
			fieldValidators.add(createFieldValidator(accepting));
		return fieldValidators;
	}
}
