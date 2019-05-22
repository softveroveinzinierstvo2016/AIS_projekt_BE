package sk.vildibald.polls.model

import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.annotations.NaturalId
import org.springframework.data.domain.Persistable
import sk.vildibald.polls.model.audit.DateAuditEntity
import sk.vildibald.polls.model.audit.PersistableEntity
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Entity
@Table(name = "priced_performance_subcategory")
data class PricedPerformanceSubcategory(

        @NaturalId
        val performanceSubcategory: Long,

        @NotNull
        val informativePrice: Int,

        @NotNull
        val priceDescription: String

) : PersistableEntity() {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JsonIgnore
    lateinit var user: User
}