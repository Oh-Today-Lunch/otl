package lee.cho.chan.otl.user.domain

import jakarta.persistence.*
import lee.cho.chan.otl.user.dto.SignUpRequest
import lombok.Getter
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.util.*

@Entity
@Table(name = "user")
@EntityListeners(AuditingEntityListener::class)
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val uuid: UUID,

    @Column(nullable = false, unique = true)
    val email: String,

    @Column(nullable = false)
    val password: String,

    @CreatedDate
    @Column(nullable = false, updatable = false)
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @LastModifiedDate
    val updatedAt: LocalDateTime? = null,

    @Column(nullable = false)
    val isAlarm: Boolean,

    val alarmTime: LocalDateTime?,

    @Column(nullable = false)
    val selectedStation: String

) {
    companion object {
        fun of(email: String, password: String, isAlarm: Boolean,selectedStation: String): User {
            return User(
                uuid = UUID.randomUUID(),
                email = email,
                password = password,
                createdAt = LocalDateTime.now(),
                updatedAt = null,
                isAlarm = isAlarm,
                alarmTime = null,
                selectedStation = selectedStation)

        }
    }

}
