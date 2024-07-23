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
        val optionalUser = userRepository.findByEmail(request.email)
        if (optionalUser.isPresent){
            throw IllegalStateException("중복임")
        }
        userRepository.save(User(request))
        return true
    }

}