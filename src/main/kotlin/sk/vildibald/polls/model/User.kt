package sk.vildibald.polls.model

import org.hibernate.annotations.NaturalId
import sk.vildibald.polls.model.audit.DateAuditEntity
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Entity
@Table(name = "users", uniqueConstraints = [
    UniqueConstraint(columnNames = ["username"]),
    UniqueConstraint(columnNames = ["email"])
])
data class User(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,

        @NotBlank
        @Size(max = 255)
        val performerName: String,

        @Size(max = 255)
        val username: String,

        @NaturalId
        @NotBlank
        @Size(max = 255)
        val email: String,

        @NotBlank
        @Size(max = 100)
        val password: String,

        val isSolo: Boolean,

        @Size(max = 255)
        val web: String,

        @Size(max = 255)
        val youtube: String,

        @Size(max = 255)
        val otherInfo: String
)
