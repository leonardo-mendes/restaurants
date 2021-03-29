package com.restaurant.searcher.resource.validation

import com.restaurant.searcher.error.exception.InvalidFieldRequestException
import com.restaurant.searcher.resource.request.RestaurantFilterRequest
import com.restaurant.searcher.resource.validation.util.Messages.distanceErrorMessage
import com.restaurant.searcher.resource.validation.util.Messages.priceErrorMessage
import com.restaurant.searcher.resource.validation.util.Messages.ratingErrorMessage
import com.restaurant.searcher.resource.validation.util.Messages.stringErrorMessage
import org.apache.logging.log4j.util.Strings.isBlank

object RestaurantRequestValidation {
    const val maxDistance: Int = 10;
    const val minDistance: Int = 1;
    const val maxRating: Int = 5;
    const val minRating: Int = 1;
    const val maxPrice: Int = 50;
    const val minPrice: Int = 10;

    fun validate(request: RestaurantFilterRequest) {
        request.apply {
            this.distance?.let { validateDistance(this.distance!!) }
            this.customerRating?.let { validateRating(this.customerRating!!) }
            this.price?.let { validatePrice(this.price!!) }
            this.cuisine?.let { validateString("Cuisine name", this.cuisine!!) }
            this.name?.let { validateString("Restaurant name", this.name!!) }
        }
    }

    private fun validateDistance(distance: Int) {
        if ((distance > maxDistance).or(distance < minDistance)) {
            throw InvalidFieldRequestException(distanceErrorMessage)
        }
    }

    private fun validateRating(rating: Int) {
        if ((rating > maxRating).or(rating < minRating)) {
            throw InvalidFieldRequestException(ratingErrorMessage)
        }
    }

    private fun validatePrice(price: Int) {
        if ((price > maxPrice).or(price < minPrice)) {
            throw InvalidFieldRequestException(priceErrorMessage)
        }
    }

    private fun validateString(field: String, value: String) {
        if (isBlank(value)) {
            throw InvalidFieldRequestException(stringErrorMessage(field))
        }
    }
}