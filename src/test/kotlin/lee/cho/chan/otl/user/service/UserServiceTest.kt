package lee.cho.chan.otl.user.service

import lee.cho.chan.otl.user.domain.User
import lee.cho.chan.otl.user.dto.LoginRequest
import lee.cho.chan.otl.user.dto.SignUpRequest
import lee.cho.chan.otl.user.repository.UserRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.BDDMockito.any
import org.mockito.BDDMockito.`when`
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import java.time.LocalDateTime
import java.util.*

@ExtendWith(MockitoExtension::class)
class UserServiceTest {

    @Mock
    private lateinit var userRepository: UserRepository

    @InjectMocks
    private lateinit var userService: UserService

    @DisplayName("id test, password test 로 회원가입 할 수 있습니다.")
    @Test
    fun signUp_success() {
        val signUpRequest = SignUpRequest("testId", "testPassword", true, "역삼역")
        val user = createUser("test.email", "password")
        `when`(userRepository.findByEmail(signUpRequest.email)).thenReturn(Optional.empty())
        `when`(userRepository.save(any(User::class.java))).thenReturn(user)

        val result = userService.signUp(signUpRequest)
        assertTrue(result)
    }

    @DisplayName("중복된 ID는 회원가입 할 수 없습니다.")
    @Test
    fun signUp_fail() {
        val email = "testId"
        val password = "testPassword"
        val signUpRequest = SignUpRequest(email, password, true, "역삼역")
        val user = createUser(email, password)
        `when`(userRepository.findByEmail(email)).thenReturn(Optional.of(user))

        assertThrows(IllegalStateException::class.java) {
            userService.signUp(signUpRequest)
        }
    }

    @DisplayName("로그인 성공")
    @Test
    fun login_success() {
        val email = "testId"
        val password = "testPassword"
        val loginRequest = LoginRequest(email, password)
        val user = createUser(email, password)

        `when`(userRepository.findByEmail(email)).thenReturn(Optional.of(user))
        val resultUser = userService.login(loginRequest)

        assertNotNull(resultUser)
    }

    private fun createUser(email: String, password: String): User {
        val user = User(
            uuid = UUID.randomUUID(),
            email = email,
            password = password,
            createdAt = LocalDateTime.now(),
            updatedAt = null,
            isAlarm = true,
            alarmTime = null,
            selectedStation = ""
        )
        return user
    }
}