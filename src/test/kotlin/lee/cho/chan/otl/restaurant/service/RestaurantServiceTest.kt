package lee.cho.chan.otl.restaurant.service

import lee.cho.chan.otl.restaurant.domain.Restaurant
import lee.cho.chan.otl.restaurant.repository.RestaurantRepository
import lee.cho.chan.otl.user.service.RestaurantService
import org.junit.jupiter.api.Assertions.assertIterableEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension
import java.time.LocalDate
import java.util.*

@ExtendWith(MockitoExtension::class)
class RestaurantServiceTest {
    @Mock
    private lateinit var restaurantRepository: RestaurantRepository

    @InjectMocks
    private lateinit var restaurantService: RestaurantService

    private lateinit var restaurant: List<Restaurant>

    @BeforeEach
    fun setUp() {
        restaurant = listOf(
            Restaurant(UUID.randomUUID(), "중식당", "중식", LocalDate.now().toString(), null, 0, "수내역"),
            Restaurant(UUID.randomUUID(), "한식당", "한식", LocalDate.now().toString(), null, 0, "수내역"),
            Restaurant(UUID.randomUUID(), "양식당", "양식", LocalDate.now().toString(), null, 0, "수내역"),
            Restaurant(UUID.randomUUID(), "일식당", "일식", LocalDate.now().toString(), null, 0, "수내역")
        )
    }

    @DisplayName("전체 음식점 조회")
    @Test
    fun get_all_restaurant_success() {
        `when`(restaurantRepository.findAll()).thenReturn(restaurant)
        val restaurantResponse = restaurantService.getAllRestaurants()

        assert(restaurantResponse.restaurants.size == 4)
        assertIterableEquals(restaurant, restaurantResponse.restaurants)
    }

    @DisplayName("수내역 음식점 조회")
    fun get_some_station_restaurant_success() {

    }

    @DisplayName("중식 카테고리의 음식점 조회")
    fun get_chinese_category_restaurant_success() {

    }

    @DisplayName("선택한 음식점의 가중치가 증가")
    fun increase_weight_success() {

    }

    @DisplayName("선택한 음식점의 정보를 수정")
    fun update_restaurant_success() {

    }
}