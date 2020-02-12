package io.shubansoft.sssm.service.calcs;

import com.google.common.collect.Iterables;
import io.shubansoft.sssm.model.StockValue;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class GeometricMeanPrice implements Function<Iterable<StockValue>,Double> {

    @Override
    public Double apply(final Iterable<StockValue> stockValues) {

        if(stockValues == null || Iterables.size(stockValues) == 0)
            return null;

        Double productPrice = 1.0;
        for (final StockValue stockValue : stockValues) {
            productPrice *= stockValue.getPrice();
        }

        final double exp = 1.0 / Iterables.size(stockValues);
        return Math.pow(productPrice,exp);
    }
}
