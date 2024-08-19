package lee.cho.chan.otl.menuSelections.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import lee.cho.chan.otl.restaurant.domain.Restaurant
import lee.cho.chan.otl.user.domain.User
import java.time.LocalDateTime
import java.util.*

@Entity
internal data class MenuSelection(
    @Id
    private val id: UUID,

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private val user: User,

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private val restaurant: Restaurant,

    @Column(nullable = false)
    private val selectCount: Int,

    @Column(nullable = false)
    private val createdAt: LocalDateTime
)
