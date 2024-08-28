package lee.cho.chan.otl.restaurant.service

import lee.cho.chan.otl.enum.Category
import lee.cho.chan.otl.enum.Station
import lee.cho.chan.otl.restaurant.domain.Restaurant
import lee.cho.chan.otl.restaurant.domain.RestaurantDto
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
import java.time.LocalDateTime
import java.util.*

@ExtendWith(MockitoExtension::class)
class RestaurantServiceTest {
    @Mock
    private lateinit var restaurantRepository: RestaurantRepository

    @InjectMocks
    private lateinit var restaurantService: RestaurantService

    private lateinit var restaurantDtos: List<RestaurantDto>

    @BeforeEach
    fun setUp() {
        restaurantDtos = listOf(
            RestaurantDto(UUID.randomUUID(), "중식당", Category.CHINESE, LocalDateTime.now(), LocalDateTime.now(), 0, Station.SUNAE),
            RestaurantDto(UUID.randomUUID(), "한식당", Category.KOREAN, LocalDateTime.now(), LocalDateTime.now(), 0, Station.SUNAE),
            RestaurantDto(UUID.randomUUID(), "양식당", Category.WESTERN, LocalDateTime.now(), LocalDateTime.now(), 0, Station.SUNAE),
            RestaurantDto(UUID.randomUUID(), "일식당", Category.JAPANESE, LocalDateTime.now(), LocalDateTime.now(), 0, Station.SUNAE)
        )
    }

    @DisplayName("전체 음식점 조회")
    @Test
    fun get_all_restaurant_success() {
        val allRestaurantDtos: List<Restaurant> = restaurantDtos.stream().map(RestaurantDto::toEntity).toList()

        `when`(restaurantRepository.findAll()).thenReturn(allRestaurantDtos)
        val restaurantResponse = restaurantService.getAllRestaurants()

        assert(restaurantResponse.restaurants.size == 4)
        assertIterableEquals(restaurantDtos, restaurantResponse.restaurants)
    }

    @DisplayName("수내역 음식점 조회")
    @Test
    fun get_some_station_restaurant_success() {
        val sunaeRestaurantDtos = restaurantDtos.stream()
            .filter { restaurantDto -> restaurantDto.station == Station.SUNAE }
            .map(RestaurantDto::toEntity)
            .toList()

        val sunaeRestaurants = restaurantDtos.stream()
            .filter { restaurantDto -> restaurantDto.station == Station.SUNAE }
            .toList()
        `when`(restaurantRepository.findByStation(Station.SUNAE)).thenReturn(sunaeRestaurantDtos)
        val restaurantResponse = restaurantService.getRestaurantsByStation(Station.SUNAE)

        assert(restaurantResponse.restaurants.size == 4)
        assertIterableEquals(sunaeRestaurants, restaurantResponse.restaurants)
    }

    @DisplayName("중식 카테고리의 음식점 조회")
    @Test
    fun get_chinese_category_restaurant_success() {
        val chinaRestaurantDtos = restaurantDtos.stream()
            .filter { restaurantDto -> restaurantDto.category == Category.CHINESE }
            .map(RestaurantDto::toEntity)
            .toList()

        val chinaRestaurants = restaurantDtos.stream()
            .filter { restaurantDto -> restaurantDto.category == Category.CHINESE }
            .toList()

        `when`(restaurantRepository.findByCategory(Category.CHINESE)).thenReturn(chinaRestaurantDtos)
        val restaurantResponse = restaurantService.getRestaurantsByCategory(Category.CHINESE)

        assert(restaurantResponse.restaurants.size == 1)
        assertIterableEquals(chinaRestaurants, restaurantResponse.restaurants)
    }
/*
    @DisplayName("선택한 음식점의 가중치가 증가")
    fun increase_weight_success() {
        val menuId = restaurantDtos.get(0).menuId
        restaurantService.pickRestaurant(menuId)
        val restaurant = restaurantService.getRestaurantById(menuId)

        assert(restaurant.weight == 1)
    }

    @DisplayName("선택한 음식점의 정보를 수정")
    fun update_restaurant_success() {
        val menuId = restaurantDtos.get(0).menuId

        val updateRequest = RestaurantUpdateRequest("중식당 테스트", Category.CHINESE, "테스트역")
        restaurantService.updateRestaurant(menuId, updateRequest)
        val restaurant = restaurantService.getRestaurantById(menuId)

        assert(restaurant.restaurantName == "중식당 테스트")
        assert(restaurant.category == Category.CHINESE)
        assert(restaurant.station == "테스트역")
    }
    */
}