package com.restaurant.searcher.service.filter.predicate.impl.step

import com.restaurant.searcher.domain.Restaurant
import com.restaurant.searcher.resource.request.FindRestaurant
import java.util.function.Predicate

class RatingPredicateProcessor : PredicateProcessor(null) {

    override fun process(request: FindRestaurant): Predicate<Restaurant>? =
        request.customerRating?.let { return retrieveRatingPredicate(request.customerRating!!) };

    private fun retrieveRatingPredicate(request: Int): Predicate<Restaurant> =
        Predicate { restaurant -> restaurant.customerRating >= request };
}