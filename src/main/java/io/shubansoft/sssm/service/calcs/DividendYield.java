package io.shubansoft.sssm.service.calcs;

import io.shubansoft.sssm.model.StockType;
import io.shubansoft.sssm.model.StockValue;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class DividendYield implements Function<StockValue,Double> {

    @Override
    public Double apply(final StockValue stockValue) {

        if(stockValue == null || stockValue.getPrice() == null || stockValue.getPrice() == 0)
            throw new IllegalArgumentException("Price cannot be Null/0");
        switch (StockType.strToType(stockValue.getStock().getType())){
            case COMMON:
                return stockValue.getStock().getLastDividend() / stockValue.getPrice();
            case PREFERRED:
                return (stockValue.getStock().getFixedDividend() * stockValue.getStock().getParValue()) /
                        (stockValue.getPrice() * 100.0) ;
            default:
                throw new RuntimeException("Unrecognized share type ["+ stockValue.getStock().getType()+"] " +
                        "for DividendYield calculation");
        }

    }
}
