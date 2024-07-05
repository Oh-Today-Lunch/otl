package lee.cho.chan.otl.menu.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.util.*


@Entity
internal data class Menu(
    @Id
    private val menuId: UUID,

    @Column(nullable = false)
    private val name: String,

    @Column(nullable = false)
    private val category: String,

    @Column(nullable = false)
    private val createdAt: String,

    private val updatedAt: String?,

    @Column(nullable = false)
    private val weight: Int,

    @Column(nullable = false)
    private val selectedStation: String
)
