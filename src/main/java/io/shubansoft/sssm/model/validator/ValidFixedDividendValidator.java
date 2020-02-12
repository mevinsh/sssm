package io.shubansoft.sssm.model.validator;

import io.shubansoft.sssm.model.Stock;
import io.shubansoft.sssm.model.StockType;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class ValidFixedDividendValidator implements ConstraintValidator<ValidFixedDividend,Object> {

    @Override
    public boolean isValid(
            final Object value,
            final ConstraintValidatorContext context) {
        if(value instanceof Stock){
            final Stock stock = (Stock)value;
            if(stock.getType() == null)
                return true; //if type not determined then cannot validate fixedDividend

            final StockType stockType = StockType.strToType(stock.getType());
            if(stockType != StockType.PREFERRED)
                return true;

            if(stock.getFixedDividend() != null){
                final double fixedDividend = stock.getFixedDividend();
                return fixedDividend >= 0.0 && fixedDividend <= 100.0;
            }
        }
        return false;
    }
}
