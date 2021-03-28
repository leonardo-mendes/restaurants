package com.restaurant.searcher.service

import com.restaurant.searcher.resource.request.FindRestaurant
import com.restaurant.searcher.resource.response.RestaurantResponse

interface RestaurantService {

    fun findRestaurants(request: FindRestaurant): List<RestaurantResponse>
}