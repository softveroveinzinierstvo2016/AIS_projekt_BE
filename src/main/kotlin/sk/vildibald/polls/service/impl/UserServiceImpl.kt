package sk.vildibald.polls.service.impl

import org.springframework.stereotype.Service
import sk.vildibald.polls.exception.ResourceNotFoundException
import sk.vildibald.polls.payload.UserIdentityAvailability
import sk.vildibald.polls.payload.UserProfile
import sk.vildibald.polls.payload.UserSummary
import sk.vildibald.polls.repository.UserRepository
import sk.vildibald.polls.security.UserPrincipal
import sk.vildibald.polls.service.UserService

@Service
class UserServiceImpl(
        val userRepository: UserRepository

) : UserService {

    override fun currentUserInfo(currentUser: UserPrincipal): UserSummary =
            UserSummary(
                    id = currentUser.id,
                    username = currentUser.username,
                    name = currentUser.name
            )

    override fun checkUsernameAvailability(newUsername: String): UserIdentityAvailability =
            UserIdentityAvailability(userRepository.existsByUsername(newUsername).not())

    override fun checkEmailAvailability(newEmail: String): UserIdentityAvailability =
            UserIdentityAvailability(userRepository.existsByEmail(newEmail).not())

    override fun userProfile(username: String): UserProfile {
        val user = (userRepository.findOneByUsername(username)
                ?: throw ResourceNotFoundException("User", "username", username))

        return UserProfile(
                id = user.id,
                username = user.username,
                name = user.name
        )
    }
}