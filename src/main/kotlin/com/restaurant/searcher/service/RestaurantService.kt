package com.restaurant.searcher.service

import com.restaurant.searcher.resource.request.RestaurantFilterRequest
import com.restaurant.searcher.resource.response.RestaurantResponse

interface RestaurantService {

    fun findRestaurants(request: RestaurantFilterRequest): List<RestaurantResponse>
}