package com.restaurant.searcher.service.filter.predicate.impl.step

import com.restaurant.searcher.domain.Restaurant
import com.restaurant.searcher.resource.request.RestaurantFilterRequest
import com.restaurant.searcher.service.filter.predicate.impl.step.util.StringUtil
import java.util.function.Predicate

class NamePredicateProcessor : PredicateProcessor(null) {

    override fun process(request: RestaurantFilterRequest): Predicate<Restaurant>? =
        request.name?.let { return retrieveNamePredicate(request.name!!) };

    private fun retrieveNamePredicate(request: String): Predicate<Restaurant> =
        Predicate { restaurant ->
            StringUtil.sanitizeString(restaurant.name)
                .contains(StringUtil.sanitizeString(request))
        }
}