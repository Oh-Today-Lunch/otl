package lee.cho.chan.otl.restaurant.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.util.*


@Entity
data class Restaurant(
    @Id
    private val menuId: UUID,

    @Column(nullable = false)
    private val restaurantName: String,

    @Column(nullable = false)
    private val category: String,

    @Column(nullable = false)
    private val createdAt: String,

    private val updatedAt: String?,

    @Column(nullable = false)
    private val weight: Int,

    @Column(nullable = false)
    private val station: String
)
