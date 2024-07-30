package lee.cho.chan.otl.user.domain

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
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
    var password: String,

    @CreatedDate
    @Column(nullable = false, updatable = false)
    var createdAt: LocalDateTime = LocalDateTime.now(),

    @LastModifiedDate
    var updatedAt: LocalDateTime? = null,

    @Column(nullable = false)
    var isAlarm: Boolean,

    var alarmTime: LocalDateTime?,

    @Column(nullable = false)
    var selectedStation: String

) {
    fun update(isAlarm: Boolean, alarmTime: String, selectedStation: String) {
        this.isAlarm = isAlarm
        this.alarmTime = LocalDateTime.parse(alarmTime)
        this.selectedStation = selectedStation
    }

    companion object {
        fun of(email: String, password: String, isAlarm: Boolean, selectedStation: String): User {
            return User(
                uuid = UUID.randomUUID(),
                email = email,
                password = password,
                createdAt = LocalDateTime.now(),
                updatedAt = null,
                isAlarm = isAlarm,
                alarmTime = null,
                selectedStation = selectedStation
            )

        }
    }

}
