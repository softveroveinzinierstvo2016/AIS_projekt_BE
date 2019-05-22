package sk.vildibald.polls.payload

data class PerformanceCategoryResponse (
        val id: Long,
        val name: String,
        val performanceSubcategories: List<PerformanceSubCategoryResponse>
)