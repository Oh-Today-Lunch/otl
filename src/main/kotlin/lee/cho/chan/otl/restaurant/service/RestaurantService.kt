package lee.cho.chan.otl.user.service

import lee.cho.chan.otl.enum.Category
import lee.cho.chan.otl.enum.Station
import lee.cho.chan.otl.restaurant.domain.RestaurantDto
import lee.cho.chan.otl.restaurant.dto.RestaurantResponse
import lee.cho.chan.otl.restaurant.repository.RestaurantRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class RestaurantService(
    private val restaurantRepository: RestaurantRepository
) {
    fun getAllRestaurants(): RestaurantResponse {
        val restaurants = restaurantRepository.findAll()
        val restaurantDtos = restaurants.stream().map { restaurant ->
            RestaurantDto(
                restaurant.menuId,
                restaurant.restaurantName,
                restaurant.category,
                restaurant.createdAt,
                restaurant.updatedAt,
                restaurant.weight,
                restaurant.station
            )
        }.toList()
        return RestaurantResponse(restaurantDtos)
    }

    fun getRestaurantsByCategory(category: Category): RestaurantResponse {
        val restaurants = restaurantRepository.findByCategory(category)
        val restaurantDtos = restaurants.stream().map { restaurant ->
            RestaurantDto(
                restaurant.menuId,
                restaurant.restaurantName,
                restaurant.category,
                restaurant.createdAt,
                restaurant.updatedAt,
                restaurant.weight,
                restaurant.station
            )
        }.toList()
        return RestaurantResponse(restaurantDtos)
    }

    fun getRestaurantsByStation(station: Station): RestaurantResponse {
        val restaurants = restaurantRepository.findByStation(station)
        val restaurantDtos = restaurants.stream().map { restaurant ->
            RestaurantDto(
                restaurant.menuId,
                restaurant.restaurantName,
                restaurant.category,
                restaurant.createdAt,
                restaurant.updatedAt,
                restaurant.weight,
                restaurant.station
            )
        }.toList()
        return RestaurantResponse(restaurantDtos)

    }
}
