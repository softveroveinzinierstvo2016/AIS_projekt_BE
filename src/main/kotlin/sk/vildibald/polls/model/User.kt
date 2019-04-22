package sk.vildibald.polls.model

import org.hibernate.annotations.NaturalId
import sk.vildibald.polls.model.audit.DateAuditEntity
import sk.vildibald.polls.payload.PerformanceSubCategoryRequest
import sk.vildibald.polls.payload.PerformerStyleRequest
import sk.vildibald.polls.payload.PerformerTypeRequest
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Entity
@Table(name = "users", uniqueConstraints = [
    UniqueConstraint(columnNames = ["username"]),
    UniqueConstraint(columnNames = ["email"])
])
data class User(

        @NotBlank
        @Size(max = 255)
        val performerName: String,

        @NotBlank
        @Size(max = 255)
        val username: String,

        @NaturalId
        @NotBlank
        @Size(max = 255)
        val email: String,

        @NotBlank
        @Size(max = 100)
        val password: String,

        @NotBlank
        val isSolo: Boolean = false,

        @NotBlank
        @ManyToMany
        val performerType: List<PerformerType>,

        @NotBlank
        @ManyToMany
        val performerStyle: List<PerformerStyle>,

        @NotBlank
        @OneToMany(fetch = FetchType.LAZY)
        val pricedPerformanceSubcategories: List<PricedPerformanceSubcategory>,

        @Size(max = 255)
        val web: String,

        @Size(max = 255)
        val youtube: String,

        @Size(max = 255)
        val otherInfo: String
) : DateAuditEntity()
