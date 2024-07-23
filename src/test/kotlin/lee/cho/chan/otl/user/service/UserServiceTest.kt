package lee.cho.chan.otl.user.service

import lee.cho.chan.otl.user.domain.User
import lee.cho.chan.otl.user.dto.SignUpRequest
import lee.cho.chan.otl.user.repository.UserRepository
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.BDDMockito.*
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import java.util.*
import org.junit.jupiter.api.Assertions;

@ExtendWith(MockitoExtension::class)
class UserServiceTest {

    @Mock
    private lateinit var userRepository: UserRepository

    @InjectMocks
    private lateinit var userService: UserService

    @DisplayName("id test, password test 로 회원가입 할 수 있습니다.")
    @Test
    fun signUp_success() {
        val signUpRequest = SignUpRequest("testId", "testPassword")
        val user = User(signUpRequest)
        `when`(userRepository.findByEmail(signUpRequest.email)).thenReturn(Optional.empty())
        `when`(userRepository.save(any(User::class.java))).thenReturn(user)

        val result = userService.signUp(signUpRequest)
        Assertions.assertTrue(result)
    }

    @DisplayName("중복된 ID는 회원가입 할 수 없습니다.")
    @Test
    fun signUp_fail() {
        val email = "testId"
        val password = "testPassword"
        val signUpRequest = SignUpRequest(email, password)
        val user = User(signUpRequest)
        `when`(userRepository.findByEmail(email)).thenReturn(Optional.of(user))

        Assertions.assertThrows(IllegalStateException::class.java){
            userService.signUp(signUpRequest)
        }
    }
}