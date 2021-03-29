package com.restaurant.searcher.service.filter

import com.restaurant.searcher.domain.Restaurant
import com.restaurant.searcher.resource.request.RestaurantFilterRequest
import java.util.function.Predicate

interface FilterService {

    fun apply(request: RestaurantFilterRequest): Predicate<Restaurant>;
}