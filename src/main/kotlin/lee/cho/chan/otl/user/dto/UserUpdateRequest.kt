package lee.cho.chan.otl.user.dto

class UserUpdateRequest(
    val email: String,
    val isAlarm: Boolean,
    val alarmTime: String,
    val selectedStation: String
) {
}