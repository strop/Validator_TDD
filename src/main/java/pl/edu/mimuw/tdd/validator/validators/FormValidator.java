package pl.edu.mimuw.tdd.validator.validators;

import java.util.ArrayList;
import java.util.List;

public class FormValidator {

	List<FieldValidator> fields = new ArrayList<FieldValidator>();
	
	List<FieldValidator> invalidFields = new ArrayList<FieldValidator>();
	
	public void addField(FieldValidator fieldValidator) {
		fields.add(fieldValidator);
	}

	public boolean isValid() {
		invalidFields.clear();
		for(FieldValidator field : fields)
			if(!field.isValid())
				invalidFields.add(field);
		return invalidFields.isEmpty();
	}

}
