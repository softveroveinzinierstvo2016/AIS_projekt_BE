package sk.vildibald.polls.payload

import sk.vildibald.polls.model.PerformerStyle
import sk.vildibald.polls.model.PerformerType
import sk.vildibald.polls.model.PricedPerformanceSubcategory

data class FilterResponse(
        val performers: List<PerformerData>
)

data class PerformerData(
        val name: String,
        val username: String,
        val email: String,
        val isSolo: Boolean = false,
        val performerType: List<PerformerType>,
        val performerStyle: List<PerformerStyle>,
        val performanceCategory: List<PricedPerformanceSubcategory>,
        val web: String,
        val youtubeLink: String,
        val otherPerformerInfo: String,
        val priceAverage: Int,
        val priceSum: Int
)