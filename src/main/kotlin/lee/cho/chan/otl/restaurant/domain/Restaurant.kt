package lee.cho.chan.otl.restaurant.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import lee.cho.chan.otl.enum.Category
import lombok.Getter
import java.time.LocalDateTime
import java.util.*


@Entity
@Getter
class Restaurant(
    @Id
    val menuId: UUID,

    @Column(nullable = false)
    val restaurantName: String,

    @Column(nullable = false)
    val category: Category,

    @Column(nullable = false)
    val createdAt: LocalDateTime,

    val updatedAt: LocalDateTime?,

    @Column(nullable = false)
    val weight: Int,

    @Column(nullable = false)
    val station: String
){

}
