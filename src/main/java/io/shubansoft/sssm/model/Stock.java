package io.shubansoft.sssm.model;

import io.shubansoft.sssm.model.validator.ValidFixedDividend;
import io.shubansoft.sssm.model.validator.ValidLastDividend;
import io.shubansoft.sssm.model.validator.ValidParValue;
import io.shubansoft.sssm.model.validator.ValidStockType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@ValidFixedDividend
public class Stock {

    @NotEmpty(message = "Stock symbol cannot be empty")
    private String symbol;

    @ValidStockType
    private String type;

    @ValidLastDividend
    private Double lastDividend;

    //validated using ValidFixedDividend depending on type of stock
    private Double fixedDividend;

    @ValidParValue
    private Double parValue;
}
