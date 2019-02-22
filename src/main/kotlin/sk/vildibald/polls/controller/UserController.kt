package sk.vildibald.polls.controller

import sk.vildibald.polls.payload.*
import sk.vildibald.polls.security.UserPrincipal

interface UserController {
    fun currentUserInfo(currentUser: UserPrincipal)
            : UserSummary

    fun checkUsernameAvailability(username: String)
            : UserIdentityAvailability

    fun checkEmailAvailability(email: String)
            : UserIdentityAvailability

    fun userProfile(username: String)
            : UserProfile


}