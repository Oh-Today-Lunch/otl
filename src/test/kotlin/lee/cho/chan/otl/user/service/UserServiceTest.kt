package lee.cho.chan.otl.user.service

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.given
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean

@SpringBootTest
class UserServiceTest {

    @MockBean
    private lateinit var userService: UserService

    @DisplayName("id test, password test 로 회원가입 할 수 있습니다.")
    @Test
    fun signUp_success() {
        val id = "testId"
        val password = "testPassword"

        given(userService.signUp(id, password)).willReturn(true);
    }

    @DisplayName("중복된 ID는 회원가입 할 수 없습니다.")
    @Test
    fun signUp_fail() {
        val id = "testId"
        val password = "testPassword"
        userService.signUp(id, password)

        given(userService.signUp(id, password)).willReturn(false);
    }
}