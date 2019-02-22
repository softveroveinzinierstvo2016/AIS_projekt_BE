package sk.vildibald.polls.payload

data class InfoResponse (
        val performer_types: List<PerformerTypeResponse>,
        val performer_styles: List<PerformerStyleResponse>,
        val performer_categories: List<PerformanceCategoryResponse>
)