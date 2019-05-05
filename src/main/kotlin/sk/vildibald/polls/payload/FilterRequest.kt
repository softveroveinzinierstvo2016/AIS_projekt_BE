package sk.vildibald.polls.payload

data class FilterRequest(
        val isSolo: Boolean,
        val performerType: List<Long>,
        val performerStyle: List<Long>,
        val performanceSubcategory:List<Long>,
        val maxPrice: Int,
        val minPrice: Int,
        val findByName: String,
        val text: String
)