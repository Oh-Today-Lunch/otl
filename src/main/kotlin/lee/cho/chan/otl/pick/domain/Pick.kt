package lee.cho.chan.otl.pick.domain

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import lee.cho.chan.otl.restaurant.domain.Restaurant
import lee.cho.chan.otl.user.domain.User
import java.util.*

@Entity
internal data class Pick(
    @Id
    private val pickId: UUID,

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private val user: User,

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private val restaurant: Restaurant,
)
