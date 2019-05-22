package sk.vildibald.polls.payload

data class FilterRequest(
        val isSolo: Boolean,
        val performerType: List<Long>,
        val performerStyle: List<Long>,
        val performanceSubcategory: List<Long>,
        val priceMin: Int,
        val priceMax: Int,
        val sortOrder: SortOrder,
        val sortType: SortType,
        val name: String
)

enum class SortOrder {
    ASC, DESC
}

enum class SortType {
    USERNAME, PRICE
}
