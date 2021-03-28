package com.restaurant.searcher.service.filter

import com.restaurant.searcher.domain.Restaurant
import java.util.function.Predicate

class CommonPredicate : Predicate<Restaurant> {
    override fun test(t: Restaurant): Boolean = true;
}