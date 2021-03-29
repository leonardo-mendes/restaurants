package com.restaurant.searcher.service.filter.impl

import com.restaurant.searcher.domain.Restaurant
import com.restaurant.searcher.resource.request.FindRestaurant
import com.restaurant.searcher.service.filter.FilterService
import com.restaurant.searcher.service.filter.predicate.impl.PredicateProcessorChain
import org.springframework.stereotype.Service
import java.util.function.Predicate

@Service
class FilterServiceImpl : FilterService {

    override fun apply(request: FindRestaurant): Predicate<Restaurant> {
        var genericPredicate: Predicate<Restaurant> = CommonPredicate();
        PredicateProcessorChain().runProcessor().buildNextPredicate(request, mutableListOf())
            .forEach { predicate ->
                genericPredicate = genericPredicate.and(predicate)
            };
        return genericPredicate;
    }

}

private class CommonPredicate : Predicate<Restaurant> {
    override fun test(t: Restaurant): Boolean = true;
}