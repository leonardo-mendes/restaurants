package com.restaurant.searcher.unit

import com.restaurant.searcher.config.cache.domain.CachedRestaurants
import com.restaurant.searcher.resource.request.FindRestaurant
import com.restaurant.searcher.resource.response.RestaurantResponse
import com.restaurant.searcher.service.RestaurantService
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RestaurantServiceTest {

    private val PARTIAL_RESTAURANT_NAME: String = "Havana"
    private val KOREAN_CUISINE: String = "Korean"

    @Autowired
    private lateinit var service: RestaurantService;

    @AfterAll
    fun cleanCache() {
        CachedRestaurants.cachedRestaurants.clear();
    }

    @Test
    fun `should retrieve 2 restaurants by partial name of Havana sorted by distance`() {
        val result: Collection<RestaurantResponse> =
            service.findRestaurants(FindRestaurant(PARTIAL_RESTAURANT_NAME, null, null, null, null));
        assertEquals(2, result.size);
        assertEquals(listOf(1, 10), result.map { restaurant -> restaurant.distance })
    }

    @Test
    fun `should retrieve 2 restaurants by partial name of Havana and Korean Cuisine`() {
        val result: Collection<RestaurantResponse> =
            service.findRestaurants(FindRestaurant(PARTIAL_RESTAURANT_NAME, null, null, null, KOREAN_CUISINE));
        assertEquals(1, result.size);
    }

    @Test
    fun `should retrieve 2 restaurants by partial name of Havana and price equals $15`() {
        val result: Collection<RestaurantResponse> =
            service.findRestaurants(FindRestaurant(PARTIAL_RESTAURANT_NAME, null, null, 15, null));
        assertEquals(1, result.size);
        assertEquals(listOf(15), result.map { restaurant -> restaurant.price })
    }

    @Test
    fun `should retrieve a empty list with filled filter`() {
        val result: Collection<RestaurantResponse> =
            service.findRestaurants(FindRestaurant("test", null, null, null, null));
        assertEquals(0, result.size);
    }

    @Test
    fun `should retrieve 5 random restaurants with no filter completed`() {
        val result: Collection<RestaurantResponse> =
            service.findRestaurants(FindRestaurant(null, null, null, null, null));
        assertEquals(5, result.size);
    }

}
