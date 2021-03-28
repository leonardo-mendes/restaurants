package com.restaurant.searcher.service.filter

import com.restaurant.searcher.domain.Restaurant
import com.restaurant.searcher.resource.request.FindRestaurant
import com.restaurant.searcher.service.filter.util.StringUtil.Companion.sanitizeString
import java.util.function.Predicate

object RestaurantPredicate {
    fun apply(request: FindRestaurant): Predicate<Restaurant> {
        var predicate: Predicate<Restaurant> = CommonPredicate();
        request.apply {
            this.name?.let { predicate = predicate.and(retrieveNamePredicate(request.name!!)) }
            this.cuisine?.let { predicate = predicate.and(retrieveCuisinePredicate(request.cuisine!!)) }
            this.customerRating?.let {
                predicate = predicate.and(retrieveRatingPredicate(request.customerRating!!))
            }
            this.distance?.let {
                predicate = predicate.and(retrieveDistancePredicate(request.distance!!))
            }
            this.price?.let { predicate = predicate.and(retrievePricePredicate(request.price!!)) }
        }.also {
            return predicate;
        }
    }

    private fun retrieveNamePredicate(request: String): Predicate<Restaurant> {
        return Predicate { restaurant -> sanitizeString(restaurant.name).contains(sanitizeString(request)) }
    }

    private fun retrieveCuisinePredicate(request: String): Predicate<Restaurant> {
        return Predicate { restaurant -> sanitizeString(restaurant.cuisine).contains(sanitizeString(request)) }
    }

    private fun retrieveRatingPredicate(request: Int): Predicate<Restaurant> {
        return Predicate { restaurant -> restaurant.customerRating >= request }
    }

    private fun retrieveDistancePredicate(request: Int): Predicate<Restaurant> {
        return Predicate { restaurant -> restaurant.distance <= request }
    }

    private fun retrievePricePredicate(request: Int): Predicate<Restaurant> {
        return Predicate { restaurant -> restaurant.price <= request }
    }
}