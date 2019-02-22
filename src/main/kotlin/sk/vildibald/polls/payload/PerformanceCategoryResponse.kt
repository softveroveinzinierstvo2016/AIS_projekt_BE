package sk.vildibald.polls.payload

data class PerformanceCategoryResponse (
        val id: Long,
        val categoryName: String,
        val subCategories: List<PerformanceSubCategoryResponse>
)