package com.restaurant.searcher.service.filter.predicate.impl.step

import com.restaurant.searcher.domain.Restaurant
import com.restaurant.searcher.resource.request.FindRestaurant
import com.restaurant.searcher.service.filter.predicate.PredicateProcessor
import java.util.function.Predicate

abstract class PredicateProcessor(var nextProcessor: com.restaurant.searcher.service.filter.predicate.impl.step.PredicateProcessor?) :
    PredicateProcessor {

    protected abstract fun process(request: FindRestaurant): Predicate<Restaurant>?;

    override fun buildNextPredicate(
        request: FindRestaurant,
        predicateList: MutableCollection<Predicate<Restaurant>>
    ): MutableCollection<Predicate<Restaurant>> {
        var newPredicate = this.process(request);
        newPredicate?.apply { predicateList.add(newPredicate) };
        nextProcessor?.buildNextPredicate(request, predicateList);
        return predicateList;
    }
}