package sk.vildibald.polls.service.impl

import org.springframework.stereotype.Service
import sk.vildibald.polls.payload.*
import sk.vildibald.polls.repository.PerformerStyleRepository
import sk.vildibald.polls.repository.PerformerTypeRepository
import sk.vildibald.polls.service.FilterService
import sk.vildibald.polls.repository.UserRepository

@Service
class FilterServiceImpl(
        private val userRepository: UserRepository,
        private val performerTypeRepository: PerformerTypeRepository,
        private val performerStyleRepository: PerformerStyleRepository
) : FilterService {

    override fun filter(filterRequest: FilterRequest): FilterResponse {

        val types = if (filterRequest.performerType.isEmpty()) performerTypeRepository.findAll().map { it.id } else filterRequest.performerType
        val styles = if (filterRequest.performerStyle.isEmpty()) performerStyleRepository.findAll().map { it.id } else filterRequest.performerStyle

        val performers = userRepository.find(filterRequest.isSolo, filterRequest.name, types, styles)
                .filter { user ->
                    filterRequest.performanceSubcategory.all {
                        user.pricedPerformanceSubcategory.any { sub -> sub.performanceSubcategory == it }
                    }
                }
                .map { user ->

                    val subcategories = if (filterRequest.performanceSubcategory.isEmpty()) user.pricedPerformanceSubcategory.map { it.id } else filterRequest.performanceSubcategory
                    val sum = subcategories.map { id -> user.pricedPerformanceSubcategory.first { it.id == id }.informativePrice }.sum()
                    val average = if (subcategories.isEmpty()) 0 else sum / subcategories.size

                    PerformerData(
                            name = user.name,
                            email = user.email,
                            isSolo = user.isSolo,
                            otherPerformerInfo = user.otherPerformerInfo,
                            performerStyle = user.performerStyle,
                            performerType = user.performerType,
                            performanceCategory = user.pricedPerformanceSubcategory,
                            web = user.web,
                            youtubeLink = user.youtubeLink,
                            username = user.username,
                            priceSum = sum,
                            priceAverage = average
                    )
                }
                .filter { it.priceSum >= filterRequest.priceMin && it.priceSum <= filterRequest.priceMax }
                .sortedWith(
                        when (filterRequest.sortType) {
                            SortType.USERNAME -> compareBy(PerformerData::priceSum)
                            SortType.PRICE -> compareBy(PerformerData::priceSum)
                        }
                )

        return if (filterRequest.sortOrder == SortOrder.DESC) FilterResponse(performers.reversed()) else FilterResponse(performers)
    }
}