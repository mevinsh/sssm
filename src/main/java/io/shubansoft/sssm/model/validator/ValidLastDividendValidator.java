package io.shubansoft.sssm.model.validator;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class ValidLastDividendValidator  implements ConstraintValidator<ValidLastDividend,Double> {

    @Override
    public boolean isValid(
            final Double lastDividend,
            final ConstraintValidatorContext context) {
        if(lastDividend == null)
            return false;

        return lastDividend.doubleValue() >= 0.0;
    }
}
