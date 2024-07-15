package lee.cho.chan.otl.user.service

import lee.cho.chan.otl.user.domain.User
import lee.cho.chan.otl.user.dto.SignUpRequest
import lee.cho.chan.otl.user.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository
) {

    fun signUp(request: SignUpRequest): Boolean {

        return try {
            userRepository.save(User(request))
            true
        } catch (e: Exception) {
            println("Error during sign-up: ${e.message}")
            false
        }
    }

}