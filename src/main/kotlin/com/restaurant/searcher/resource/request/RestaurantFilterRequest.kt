package com.restaurant.searcher.resource.request

import com.restaurant.searcher.resource.validation.RestaurantRequestValidation

data class RestaurantFilterRequest(
    var name: String?,
    var customerRating: Int?,
    var distance: Int?,
    var price: Int?,
    var cuisine: String?
) {

    fun validate() {
        RestaurantRequestValidation.validate(this);
    }

}
