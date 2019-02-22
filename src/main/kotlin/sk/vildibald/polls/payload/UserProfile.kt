package sk.vildibald.polls.payload

import java.time.Instant

data class UserProfile(
        val id: Long,
        val username: String,
        val name: String
)