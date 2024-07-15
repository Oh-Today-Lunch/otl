package lee.cho.chan.otl.user.domain

import jakarta.persistence.*
import lee.cho.chan.otl.user.dto.SignUpRequest
import java.time.LocalDate
import java.time.LocalTime
import java.util.*

@Entity
@Table(name = "user")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private val uuid: UUID,

    @Column(nullable = false, unique = true)
    private val email: String,

    @Column(nullable = false)
    private val password: String,

    @Column(nullable = false)
    private val createdAt: String,

    private val updatedAt: LocalDate?,

    @Column(nullable = false)
    private val isAlarm: Boolean,

    private val alarmTime: LocalTime?,

    @Column(nullable = false)
    private val selectedStation: String

) {
    constructor(signUpRequest: SignUpRequest) : this(
        uuid = UUID.randomUUID(),
        email = signUpRequest.email,
        password = signUpRequest.password,
        createdAt = LocalDate.now().toString(),
        updatedAt = null,
        isAlarm = false,
        alarmTime = null,
        selectedStation = null.toString()
    )
}
