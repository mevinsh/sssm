package io.shubansoft.sssm.service.calcs;

import com.google.common.collect.Iterables;
import io.shubansoft.sssm.model.Trade;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class VolumeWeightedPrice implements BiFunction<Iterable<Trade>, Predicate<Trade>,Double> {

    @Override
    public Double apply(final Iterable<Trade> trades, final Predicate<Trade> tradeReq) {
        if(trades == null || Iterables.size(trades) == 0)
            return null;
        final List<Trade> filteredTrades = StreamSupport.stream(trades.spliterator(),false)
                .filter(t->tradeReq.test(t))
                .collect(Collectors.toList());
        if(filteredTrades.size() == 0)
            return null;
        final Double totalQuantity = filteredTrades.stream().collect(Collectors.summingDouble(Trade::getQuantity));
        double weightedSum = filteredTrades.stream()
                .map(trade-> (trade.getTradePrice() * trade.getQuantity()))
                .mapToDouble(Double::doubleValue)
                .sum();
//        for (final Trade trade : filteredTrades) {
//            weightedSum += (trade.getTradePrice() * trade.getQuantity());
//        }
        return weightedSum/totalQuantity;
    }
}
