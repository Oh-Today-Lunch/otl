package lee.cho.chan.otl.restaurant.repository

import lee.cho.chan.otl.restaurant.domain.Restaurant
import lee.cho.chan.otl.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface RestaurantRepository : JpaRepository<Restaurant, Long> {

}