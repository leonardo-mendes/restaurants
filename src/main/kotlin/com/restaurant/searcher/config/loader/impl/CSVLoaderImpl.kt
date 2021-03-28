package com.restaurant.searcher.config.loader.impl

import com.opencsv.bean.CsvToBeanBuilder
import com.restaurant.searcher.config.loader.CSVLoader
import com.restaurant.searcher.config.loader.domain.CSVCuisine
import com.restaurant.searcher.config.loader.domain.CSVRestaurant
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.io.FileReader

@Component
class CSVLoaderImpl : CSVLoader {

    @Value("\${restaurant.csv.file}")
    lateinit var restaurantFilePath: String;

    @Value("\${cuisine.csv.file}")
    lateinit var cuisineFilePath: String

    override fun readRestaurantCSV(): Collection<CSVRestaurant> =
        CsvToBeanBuilder<CSVRestaurant>(FileReader(restaurantFilePath))
            .withType(CSVRestaurant::class.javaObjectType)
            .withSkipLines(1)
            .build()
            .parse();

    override fun readCuisineCSV(): Collection<CSVCuisine> =
        CsvToBeanBuilder<CSVCuisine>(FileReader(cuisineFilePath))
            .withType(CSVCuisine::class.java)
            .withSkipLines(1)
            .build()
            .parse();
}