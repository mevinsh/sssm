package io.shubansoft.sssm.model.validator;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class ValidParValueValidator implements ConstraintValidator<ValidParValue,Double> {

    @Override
    public boolean isValid(
            final Double parValue,
            final ConstraintValidatorContext context) {
        if(parValue == null)
            return false;
        return parValue.doubleValue() >= 0.0;
    }
}
