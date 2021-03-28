package com.restaurant.searcher.config.loader.domain

import com.opencsv.bean.CsvBindByPosition

data class CSVRestaurant(
    @CsvBindByPosition(position = 0)
    var name: String = "",
    @CsvBindByPosition(position = 1)
    var customerRating: String = "",
    @CsvBindByPosition(position = 2)
    var distance: String = "",
    @CsvBindByPosition(position = 3)
    var price: String = "",
    @CsvBindByPosition(position = 4)
    var cuisineId: String = ""
)
