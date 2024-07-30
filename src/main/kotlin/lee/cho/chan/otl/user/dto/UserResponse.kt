package lee.cho.chan.otl.user.dto

import java.time.LocalDateTime

class UserResponse(
    val email: String,
    val isAlarm: Boolean,
    val alarmTime: String,
    val selectedStation: String
) {
}