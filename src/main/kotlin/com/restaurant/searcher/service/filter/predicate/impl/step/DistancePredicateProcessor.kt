package com.restaurant.searcher.service.filter.predicate.impl.step

import com.restaurant.searcher.domain.Restaurant
import com.restaurant.searcher.resource.request.FindRestaurant
import java.util.function.Predicate

class DistancePredicateProcessor : PredicateProcessor(null) {

    override fun process(request: FindRestaurant): Predicate<Restaurant>? =
        request.distance?.let { return retrieveDistancePredicate(request.distance!!) };

    private fun retrieveDistancePredicate(request: Int): Predicate<Restaurant> =
        Predicate { restaurant -> restaurant.distance <= request };
}