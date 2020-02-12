package io.shubansoft.sssm.model;

import io.shubansoft.sssm.model.validator.ValidPrice;
import lombok.Value;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Value
public class StockValue {

    @NotNull
    @Valid
    private final Stock stock;

    @NotNull
    private final LocalDate date;

    @ValidPrice
    private final Double price;
}
