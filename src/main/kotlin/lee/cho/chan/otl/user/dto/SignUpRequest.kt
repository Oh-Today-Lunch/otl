package lee.cho.chan.otl.user.dto

class SignUpRequest(
    val email: String,
    val password: String,
    val isAlram : Boolean,
    val selectedStation : String
) {
}