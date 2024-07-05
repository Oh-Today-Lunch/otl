package lee.cho.chan.otl.group.domain

import jakarta.persistence.*
import lee.cho.chan.otl.user.domain.User
import java.time.LocalDateTime
import java.util.*

@Entity
internal data class Group(
    @Id
    private val id: UUID,

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private val user: User,

    @Column(nullable = false)
    private val createdAt: LocalDateTime
)
