package com.restaurant.searcher.service.comparator

import com.restaurant.searcher.domain.Restaurant

object RestaurantComparator {
    fun apply(): Comparator<Restaurant> {
        return Comparator { firstElement, secondElement ->
            var comparation: Int
            comparation = firstElement.distance.compareTo(secondElement.distance)
            if (comparation == 0) {
                comparation = secondElement.customerRating.compareTo(firstElement.customerRating)
            }
            if (comparation == 0) {
                comparation = firstElement.price.compareTo(secondElement.price)
            }
            comparation
        }
    }
}