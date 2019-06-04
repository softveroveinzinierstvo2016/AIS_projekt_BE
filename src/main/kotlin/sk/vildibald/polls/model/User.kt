package sk.vildibald.polls.model

import org.hibernate.annotations.NaturalId
import org.hibernate.validator.constraints.Length
import sk.vildibald.polls.model.audit.PersistableEntity
import javax.persistence.*
import javax.validation.constraints.Size

@Entity
@Table(name = "users", uniqueConstraints = [
    UniqueConstraint(columnNames = ["username"]),
    UniqueConstraint(columnNames = ["email"])
])
data class User(

        @field:Length(max = 255)
        val username: String,

        @field:Length(max = 100)
        val password: String,

        @field:Length(max = 255)
        val name: String,

        @NaturalId
        @field:Length(max = 255)
        val email: String,

        val isSolo: Boolean,

        @ManyToMany
        val performerType: List<PerformerType>,

        @ManyToMany
        val performerStyle: List<PerformerStyle>,

        @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
        val pricedPerformanceSubcategory: List<PricedPerformanceSubcategory>,

        @field:Length(max = 255)
        val web: String,

        @field:Length(max = 255)
        val youtubeLink: String,

        //@Length(max = 1000)
        @field:Length(max = 1000)
        val otherPerformerInfo: String
) : PersistableEntity()
