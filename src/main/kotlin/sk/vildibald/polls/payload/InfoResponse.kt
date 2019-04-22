package sk.vildibald.polls.payload

data class InfoResponse (
        val performerTypes: List<PerformerTypeResponse>,
        val performerStyles: List<PerformerStyleResponse>,
        val performerCategories: List<PerformanceCategoryResponse>
)