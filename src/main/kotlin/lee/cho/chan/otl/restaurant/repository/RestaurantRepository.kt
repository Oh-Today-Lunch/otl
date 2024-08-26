package lee.cho.chan.otl.restaurant.repository

import lee.cho.chan.otl.enum.Category
import lee.cho.chan.otl.restaurant.domain.Restaurant
import lee.cho.chan.otl.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface RestaurantRepository : JpaRepository<Restaurant, Long> {
    fun findByStation(station: String) : List<Restaurant>

    @Query("SELECT r FROM Restaurant r WHERE r.category = :category")
    fun findByCategory(category: Category): List<Restaurant>
}