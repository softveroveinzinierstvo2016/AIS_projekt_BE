package sk.vildibald.polls.controller.impl

import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*
import sk.vildibald.polls.controller.UserController
import sk.vildibald.polls.payload.UserIdentityAvailability
import sk.vildibald.polls.payload.UserProfile
import sk.vildibald.polls.payload.UserSummary
import sk.vildibald.polls.security.CurrentUser
import sk.vildibald.polls.security.UserPrincipal
import sk.vildibald.polls.service.UserService

@RestController
@RequestMapping("/api")
class UserControllerImpl(
        private val userService: UserService
) : UserController {

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    override fun currentUserInfo(@CurrentUser currentUser: UserPrincipal)
            : UserSummary = userService.currentUserInfo(currentUser)

    @GetMapping("/user/checkUsernameAvailability")
    override fun checkUsernameAvailability(@RequestParam(value = "username") username: String)
            : UserIdentityAvailability = userService.checkUsernameAvailability(username)

    @GetMapping("/user/checkEmailAvailability")
    override fun checkEmailAvailability(@RequestParam(value = "email") email: String)
            : UserIdentityAvailability = userService.checkEmailAvailability(email)

    @GetMapping("/users/{username}")
    override fun userProfile(@PathVariable(value = "username") username: String):
            UserProfile = userService.userProfile(username)
}