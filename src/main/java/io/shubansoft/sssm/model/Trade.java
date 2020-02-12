package io.shubansoft.sssm.model;

import io.shubansoft.sssm.model.validator.ValidPrice;
import io.shubansoft.sssm.model.validator.ValidTradeIndicator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Value
public class Trade {

    @NotNull
    private String tradeId;

    @NotNull
    private Long tradeTimestamp;

    @ValidPrice
    private Double tradePrice;

    @Min(value = 1)
    private Integer quantity;

    @NotNull
    private String symbol;

    @ValidTradeIndicator
    private String tradeIndicator;

}
