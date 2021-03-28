package com.restaurant.searcher.config.cache.domain

import com.restaurant.searcher.domain.Restaurant

object CachedRestaurants {
    val cachedRestaurants: MutableCollection<Restaurant> = ArrayList();
}