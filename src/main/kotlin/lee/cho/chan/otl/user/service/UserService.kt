package lee.cho.chan.otl.user.service

import lee.cho.chan.otl.user.domain.User
import lee.cho.chan.otl.user.dto.LoginRequest
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
        val user = User.of(request.email,request.password,request.isAlram,request.selectedStation)
        userRepository.save(user)
        return true
    }

    fun login(request : LoginRequest) : Boolean {
        val optionalUser = userRepository.findByEmail(request.email);
        if (optionalUser.isEmpty){
            throw IllegalStateException("아이디가 존재하지 않습니다")
        }
        val user = optionalUser.get()
        if (user.password != request.password){
            throw IllegalStateException("비밀번호가 틀립니다")
        }
        return true
    }

}
