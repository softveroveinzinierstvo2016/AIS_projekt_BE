package sk.vildibald.polls.payload

import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class SignUpRequest(
        @Id
        val id: Long,

        @NotBlank
        @Size(min = 4, max = 40)
        val name: String,

        @NotBlank
        @Size(min = 3, max = 15)
        val username: String,

        @NotBlank
        @Size(max = 40)
        @Email
        val email: String,

        @NotBlank
        @Size(min = 6, max = 20)
        val password: String,

        val isSolo: Boolean,

        @Size(max = 255)
        val web: String,

        @Size(max = 255)
        val youtube: String,

        @Size(max = 255)
        val otherInfo: String
)