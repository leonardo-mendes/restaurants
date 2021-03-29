package com.restaurant.searcher.service.filter.predicate.impl.step

import com.restaurant.searcher.domain.Restaurant
import com.restaurant.searcher.resource.request.FindRestaurant
import com.restaurant.searcher.service.filter.predicate.impl.step.util.StringUtil
import java.util.function.Predicate

class CuisinePredicateProcessor : PredicateProcessor(null) {

    override fun process(request: FindRestaurant): Predicate<Restaurant>? =
        request.cuisine?.let { return retrieveNamePredicate(request.cuisine!!) };

    private fun retrieveNamePredicate(request: String): Predicate<Restaurant> =
        Predicate { restaurant ->
            StringUtil.sanitizeString(restaurant.cuisine)
                .contains(StringUtil.sanitizeString(request))
        };
}