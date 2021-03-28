package com.restaurant.searcher.config.loader

import com.restaurant.searcher.config.loader.domain.CSVCuisine
import com.restaurant.searcher.config.loader.domain.CSVRestaurant

interface CSVLoader {

    fun readRestaurantCSV(): Collection<CSVRestaurant>;

    fun readCuisineCSV(): Collection<CSVCuisine>;
}