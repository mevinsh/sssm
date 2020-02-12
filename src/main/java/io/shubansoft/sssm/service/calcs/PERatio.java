package io.shubansoft.sssm.service.calcs;

import io.shubansoft.sssm.model.Stock;
import io.shubansoft.sssm.model.StockValue;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.function.BiFunction;
import java.util.function.Function;

@Service
public class PERatio implements Function<StockValue,Double> {

    private final DividendYield dividendYield;

    @Inject
    public PERatio(final DividendYield dividendYield){
        this.dividendYield = dividendYield;
    }

    @Override
    public Double apply(final StockValue stockValue) {
        return stockValue.getPrice() / dividendYield.apply(stockValue);
    }
}