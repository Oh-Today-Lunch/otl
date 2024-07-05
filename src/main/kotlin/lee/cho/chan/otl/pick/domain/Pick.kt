package lee.cho.chan.otl.pick.domain

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import lee.cho.chan.otl.menu.domain.Menu
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
    @JoinColumn(name = "menu_id", nullable = false)
    private val menu: Menu,
)
