package com.restaurant.searcher.config.cache

import com.restaurant.searcher.config.cache.domain.CachedRestaurants.cachedRestaurants
import com.restaurant.searcher.config.loader.CSVLoader
import com.restaurant.searcher.config.loader.domain.CSVCuisine
import com.restaurant.searcher.config.loader.domain.CSVRestaurant
import com.restaurant.searcher.domain.Restaurant
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

@Component
class CachedData {

    @Autowired
    lateinit var csvLoader: CSVLoader;

    @PostConstruct
    fun loadFiles(): MutableCollection<Restaurant> =
        loadRestaurants(csvLoader.readRestaurantCSV(), csvLoader.readCuisineCSV());

    fun loadRestaurants(
        csvRestaurants: Collection<CSVRestaurant>,
        csvCuisines: Collection<CSVCuisine>
    ): MutableCollection<Restaurant> {
        val cuisineMap = loadCuisines(csvCuisines);
        csvRestaurants.forEach {
            cachedRestaurants.add(
                Restaurant(
                    it.name,
                    it.customerRating.toInt(),
                    it.distance.toInt(),
                    it.price.toInt(),
                    cuisineMap[it.cuisineId]!!
                )
            )
        }.also {
            return cachedRestaurants;
        }
    }

    fun loadCuisines(csvCuisines: Collection<CSVCuisine>): Map<String, String> =
        csvCuisines.map { it.id to it.name }.toMap();

}