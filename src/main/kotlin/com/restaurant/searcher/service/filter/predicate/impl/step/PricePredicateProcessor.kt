package com.restaurant.searcher.service.filter.predicate.impl.step

import com.restaurant.searcher.domain.Restaurant
import com.restaurant.searcher.resource.request.FindRestaurant
import java.util.function.Predicate

class PricePredicateProcessor : PredicateProcessor(null) {

    override fun process(request: FindRestaurant): Predicate<Restaurant>? =
        request.price?.let { return retrievePricePredicate(request.price!!) };

    private fun retrievePricePredicate(request: Int): Predicate<Restaurant> =
        Predicate { restaurant -> restaurant.price <= request };
}