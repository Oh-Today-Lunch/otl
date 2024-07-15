package lee.cho.chan.otl.user.controller

import lee.cho.chan.otl.user.dto.SignUpRequest
import lee.cho.chan.otl.user.dto.SignUpResponse
import lee.cho.chan.otl.user.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class UserController(
    private val userService: UserService,
) {

    @PostMapping("/user")
    fun signUp(@RequestBody request: SignUpRequest): ResponseEntity<Boolean> {
        val boolean = userService.signUp(request);
        return ResponseEntity.ok(boolean);
    }
}
