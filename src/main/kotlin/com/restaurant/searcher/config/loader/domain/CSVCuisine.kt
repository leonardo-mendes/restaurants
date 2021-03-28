package com.restaurant.searcher.config.loader.domain

import com.opencsv.bean.CsvBindByPosition

data class CSVCuisine(
    @CsvBindByPosition(position = 0)
    var id: String = "",
    @CsvBindByPosition(position = 1)
    var name: String = ""
)
