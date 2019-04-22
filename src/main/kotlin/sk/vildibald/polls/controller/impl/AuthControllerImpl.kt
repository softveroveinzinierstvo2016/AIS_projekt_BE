package sk.vildibald.polls.controller.impl

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import sk.vildibald.polls.controller.AuthController
import sk.vildibald.polls.payload.LoginRequest
import sk.vildibald.polls.payload.SignUpRequest
import sk.vildibald.polls.service.AuthService


@RestController
@RequestMapping("/api")
class AuthControllerImpl(
private val authService: AuthService
) : AuthController {

    @PostMapping("/signin")
    override fun authenticateUser(loginRequest: LoginRequest): ResponseEntity<*> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    @PostMapping("/signup")
    override fun registerUser(signUpRequest: SignUpRequest): ResponseEntity<*> {
        val response = authService.registerUser(signUpRequest)
        return if (response.success.not()) {
            ResponseEntity(response, HttpStatus.BAD_REQUEST)
        } else {
            val location = ServletUriComponentsBuilder
                    .fromCurrentContextPath().path("/users/{username}")
                    .buildAndExpand(signUpRequest.username).toUri()
            // Redirect frontend to the given location.
            ResponseEntity.created(location).body(response)
        }
    }
}