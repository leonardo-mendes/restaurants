package com.restaurant.searcher.domain

import com.restaurant.searcher.resource.response.RestaurantResponse

data class Restaurant(
    var name: String = "",
    var customerRating: Int = 0,
    var distance: Int = 0,
    var price: Int = 0,
    var cuisine: String = ""
) {
    fun buildResponse() =
        RestaurantResponse(
            this.name,
            this.customerRating,
            this.distance,
            this.price,
            this.cuisine
        )
}
