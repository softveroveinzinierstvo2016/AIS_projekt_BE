package sk.vildibald.polls.payload

data class PricedPerformanceSubcategoryRequest(
        val performanceSubcategory: Long,
        val informativePrice: Int,
        val priceDescription: String
)