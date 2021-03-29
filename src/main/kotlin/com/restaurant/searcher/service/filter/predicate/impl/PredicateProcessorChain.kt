package com.restaurant.searcher.service.filter.predicate.impl

import com.restaurant.searcher.service.filter.predicate.impl.step.*
import org.springframework.stereotype.Component

@Component
class PredicateProcessorChain {

    fun runProcessor(): PredicateProcessor {
        var nameProcessor = NamePredicateProcessor();
        var cuisineProcessor = CuisinePredicateProcessor();
        var ratingProcessor = RatingPredicateProcessor();
        var distanceProcessor = DistancePredicateProcessor();
        var priceProcessor = PricePredicateProcessor();

        nameProcessor.nextProcessor = cuisineProcessor;
        cuisineProcessor.nextProcessor = ratingProcessor;
        ratingProcessor.nextProcessor = distanceProcessor;
        distanceProcessor.nextProcessor = priceProcessor;
        return nameProcessor;
    }


}