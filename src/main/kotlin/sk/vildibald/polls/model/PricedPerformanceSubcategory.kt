package sk.vildibald.polls.model

import sk.vildibald.polls.model.audit.DateAuditEntity
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "priced_performance_subcategory")
data class PricedPerformanceSubcategory(

        @NotBlank
        val performanceSubcategory: Long,

        val informativePrice: Int,

        @NotBlank
        val priceDescription: String,

        @ManyToOne(fetch = FetchType.EAGER)
        val user: User

) : DateAuditEntity()