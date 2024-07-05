package lee.cho.chan.otl.user.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDate
import java.time.LocalTime
import java.util.*

@Entity
@Table(name = "user")
internal data class User(
    @Id
    private val userId: UUID,

    @Column(nullable = false)
    private val name: String,

    @Column(nullable = false, unique = true)
    private val email: String,

    @Column(nullable = false)
    private val password: String,

    @Column(nullable = false)
    private val createdAt: String,

    private val updatedAt: LocalDate?,

    @Column(nullable = false)
    private val alarmTime: LocalTime,

    @Column(nullable = false)
    private val selectedStation: String

) {

}

