package lee.cho.chan.otl.user.service

import lee.cho.chan.otl.restaurant.domain.Restaurant
import lee.cho.chan.otl.restaurant.dto.RestaurantResponse
import lee.cho.chan.otl.restaurant.repository.RestaurantRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class RestaurantService(
    private val restaurantRepository: RestaurantRepository
) {
    fun getAllRestaurants() : RestaurantResponse{
        return RestaurantResponse(restaurantRepository.findAll())
    }
}
