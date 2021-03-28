package com.restaurant.searcher.integration

import com.fasterxml.jackson.databind.ObjectMapper
import com.restaurant.searcher.config.cache.domain.CachedRestaurants
import com.restaurant.searcher.resource.request.FindRestaurant
import com.restaurant.searcher.resource.response.RestaurantResponse
import com.restaurant.searcher.resource.validation.util.Messages.distanceErrorMessage
import com.restaurant.searcher.resource.validation.util.Messages.priceErrorMessage
import com.restaurant.searcher.resource.validation.util.Messages.ratingErrorMessage
import com.restaurant.searcher.resource.validation.util.Messages.stringErrorMessage
import org.hamcrest.Matchers
import org.hamcrest.Matchers.hasSize
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RestaurantResourceTest {

    private val RESTAURANT_URL: String = "/restaurants";
    private val JSON_EXPRESSION: String = "$.message";

    @Autowired
    lateinit var mockMvc: MockMvc;

    @Autowired
    lateinit var mapper: ObjectMapper;

    @AfterAll
    fun cleanCache() {
        CachedRestaurants.cachedRestaurants.clear();
    }

    @Test
    fun `should return Lucha Yummy restaurant data`() {
        mockMvc.perform(
            post(RESTAURANT_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(FindRestaurant("Lucha Yummy", null, null, null, null)))
        )
            .andExpect(status().isOk)
            .andExpect(jsonPath("$", hasSize<RestaurantResponse>(1)))
            .andExpect(jsonPath("$.[0]name", Matchers.`is`("Lucha Yummy")))
            .andExpect(jsonPath("$.[0]customerRating", Matchers.`is`(1)))
            .andExpect(jsonPath("$.[0]distance", Matchers.`is`(10)))
            .andExpect(jsonPath("$.[0]price", Matchers.`is`(40)))
            .andExpect(jsonPath("$.[0]cuisine", Matchers.`is`("Thai")));
    }

    @Test
    fun `should return error when send a invalid name param`() {
        mockMvc.perform(
            post(RESTAURANT_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(FindRestaurant(" ", null, null, null, null)))
        )
            .andExpect(status().isBadRequest)
            .andExpect(jsonPath(JSON_EXPRESSION, Matchers.`is`(stringErrorMessage("Restaurant name"))));
    }

    @Test
    fun `should return error when send a invalid cuisine param`() {
        mockMvc.perform(
            post(RESTAURANT_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(FindRestaurant(null, null, null, null, " ")))
        )
            .andExpect(status().isBadRequest)
            .andExpect(jsonPath(JSON_EXPRESSION, Matchers.`is`(stringErrorMessage("Cuisine name"))));
    }

    @Test
    fun `should return error when send a invalid customer rating param`() {
        mockMvc.perform(
            post(RESTAURANT_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(FindRestaurant(null, 10, null, null, null)))
        )
            .andExpect(status().isBadRequest)
            .andExpect(jsonPath(JSON_EXPRESSION, Matchers.`is`(ratingErrorMessage)))
    }

    @Test
    fun `should return error when send a invalid distance param`() {
        mockMvc.perform(
            post(RESTAURANT_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(FindRestaurant(null, null, 11, null, null)))
        )
            .andExpect(status().isBadRequest)
            .andExpect(
                jsonPath(
                    JSON_EXPRESSION,
                    Matchers.`is`(distanceErrorMessage)
                )
            )
    }

    @Test
    fun `should return error when send a invalid price param`() {
        mockMvc.perform(
            post(RESTAURANT_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(FindRestaurant(null, null, null, 100, null)))
        )
            .andExpect(status().isBadRequest)
            .andExpect(jsonPath(JSON_EXPRESSION, Matchers.`is`(priceErrorMessage)))
    }

}
