package lee.cho.chan.otl.restaurant.domain

import lee.cho.chan.otl.enum.Category
import lee.cho.chan.otl.enum.Station
import java.time.LocalDateTime
import java.util.*

data class RestaurantDto(
    val menuId: UUID,
    val restaurantName: String,
    val category: Category,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime?,
    val weight: Int,
    val station: Station
) {
    fun toEntity(): Restaurant {
        return Restaurant(
            menuId = menuId,
            restaurantName = restaurantName,
            category = category,
            createdAt = createdAt,
            updatedAt = updatedAt,
            weight = weight,
            station = station
        )
    }

}