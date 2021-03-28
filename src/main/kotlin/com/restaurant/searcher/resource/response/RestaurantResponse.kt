package com.restaurant.searcher.resource.response

data class RestaurantResponse(
    var name: String,
    var customerRating: Int,
    var distance: Int,
    var price: Int,
    var cuisine: String
)