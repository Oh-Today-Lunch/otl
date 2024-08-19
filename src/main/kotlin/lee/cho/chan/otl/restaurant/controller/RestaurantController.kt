package lee.cho.chan.otl.user.controller

import lee.cho.chan.otl.user.service.RestaurantService
import org.springframework.web.bind.annotation.RestController



@RestController
class RestaurantController(
    private val restaurantService: RestaurantService,
) {

}
