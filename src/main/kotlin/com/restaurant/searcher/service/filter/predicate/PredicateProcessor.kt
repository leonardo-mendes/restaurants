package com.restaurant.searcher.service.filter.predicate

import com.restaurant.searcher.domain.Restaurant
import com.restaurant.searcher.resource.request.FindRestaurant
import java.util.function.Predicate

interface PredicateProcessor {

    fun buildNextPredicate(
        request: FindRestaurant,
        predicateList: MutableCollection<Predicate<Restaurant>>
    ): MutableCollection<Predicate<Restaurant>>;
}