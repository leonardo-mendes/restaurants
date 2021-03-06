package com.restaurant.searcher.service.impl

import com.restaurant.searcher.config.cache.domain.CachedRestaurants.cachedRestaurants
import com.restaurant.searcher.resource.request.RestaurantFilterRequest
import com.restaurant.searcher.resource.response.RestaurantResponse
import com.restaurant.searcher.service.RestaurantService
import com.restaurant.searcher.service.comparator.RestaurantComparator
import com.restaurant.searcher.service.filter.FilterService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import kotlin.streams.toList

@Service
class RestaurantServiceImpl : RestaurantService {

    @Value("\${result.max}")
    lateinit var maxMatches: String;

    @Autowired
    lateinit var filterService: FilterService;

    override fun findRestaurants(request: RestaurantFilterRequest): List<RestaurantResponse> {
        return cachedRestaurants.stream()
            .filter(filterService.apply(request))
            .sorted(RestaurantComparator.apply())
            .limit(maxMatches.toLong())
            .map { it.buildResponse() }
            .toList();
    }
}