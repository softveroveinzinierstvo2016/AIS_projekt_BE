package sk.vildibald.polls.model

import org.hibernate.annotations.NaturalId
import sk.vildibald.polls.model.audit.PersistableEntity
import javax.persistence.*
import javax.validation.constraints.Size

@Entity
@Table(name = "users", uniqueConstraints = [
    UniqueConstraint(columnNames = ["username"]),
    UniqueConstraint(columnNames = ["email"])
])
data class User(

        @Size(max = 255)
        val username: String,

        @Size(max = 100)
        val password: String,

        @Size(max = 255)
        val name: String,

        @NaturalId
        @Size(max = 255)
        val email: String,

        val isSolo: Boolean,

        @ManyToMany
        val performerType: List<PerformerType>,

        @ManyToMany
        val performerStyle: List<PerformerStyle>,

        @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
        val pricedPerformanceSubcategory: List<PricedPerformanceSubcategory>,

        @Size(max = 255)
        val web: String,

        @Size(max = 255)
        val youtubeLink: String,

        @Size(max = 255)
        val otherPerformerInfo: String
) : PersistableEntity()
