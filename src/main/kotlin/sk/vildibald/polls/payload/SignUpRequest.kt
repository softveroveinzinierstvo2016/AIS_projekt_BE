package sk.vildibald.polls.payload

data class SignUpRequest(
        val username: String,
        val password: String,
        val name: String,
        val email: String,
        val isSolo: Boolean = false,
        val performerType: List<Long>,
        val performerStyle: List<Long>,
        val pricedPerformanceSubcategory: List<PricedPerformanceSubcategoryRequest>,
        val web: String = "",
        val youtubeLink: String = "",
        val otherPerformerInfo: String
)