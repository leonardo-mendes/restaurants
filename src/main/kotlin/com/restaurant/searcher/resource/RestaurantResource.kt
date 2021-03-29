package com.restaurant.searcher.resource

import com.restaurant.searcher.resource.request.RestaurantFilterRequest
import com.restaurant.searcher.resource.response.RestaurantResponse
import com.restaurant.searcher.service.RestaurantService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/restaurants")
class RestaurantResource {

    @Autowired
    lateinit var service: RestaurantService;

    @PostMapping
    fun filterRestaurant(@RequestBody request: RestaurantFilterRequest): List<RestaurantResponse> {
        request.validate()
            .also { return service.findRestaurants(request) };
    }

}