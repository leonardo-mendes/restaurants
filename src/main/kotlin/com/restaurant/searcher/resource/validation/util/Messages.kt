package com.restaurant.searcher.resource.validation.util

import com.restaurant.searcher.resource.validation.RestaurantRequestValidation.maxDistance
import com.restaurant.searcher.resource.validation.RestaurantRequestValidation.maxPrice
import com.restaurant.searcher.resource.validation.RestaurantRequestValidation.maxRating
import com.restaurant.searcher.resource.validation.RestaurantRequestValidation.minDistance
import com.restaurant.searcher.resource.validation.RestaurantRequestValidation.minPrice
import com.restaurant.searcher.resource.validation.RestaurantRequestValidation.minRating

object Messages {
    const val distanceErrorMessage: String =
        "Distance should be between $minDistance and $maxDistance.";
    const val ratingErrorMessage: String =
        "Rating should be between $minRating and $maxRating.";
    const val priceErrorMessage: String =
        "Price should be between $minPrice and $maxPrice";

    fun stringErrorMessage(field: String): String = "$field can not be blank";

}