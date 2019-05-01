package sk.vildibald.polls.payload

import javax.validation.constraints.NotBlank

data class PricedPerformanceSubcategoryRequest (

    @NotBlank
    val performanceSubcategory: Long,

    val informativePrice: Int,

    @NotBlank
    val priceDescription: String,

    val user: Long
)