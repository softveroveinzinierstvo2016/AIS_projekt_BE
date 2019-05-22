package sk.vildibald.polls.service.impl

import org.springframework.stereotype.Service
import sk.vildibald.polls.payload.*
import sk.vildibald.polls.repository.PerformanceCategoryRepository
import sk.vildibald.polls.repository.PerformerStyleRepository
import sk.vildibald.polls.repository.PerformerTypeRepository
import sk.vildibald.polls.service.InfoService

@Service
class InfoServiceImpl(private val performanceCategoryRepository: PerformanceCategoryRepository,
                      private val performerTypeRepository: PerformerTypeRepository,
                      private val performerStyleRepository: PerformerStyleRepository) : InfoService {

    override fun allInfo(): InfoResponse {
        val categories = performanceCategoryRepository.findAll()
        val categoryResponsesData = categories.map { category ->
            PerformanceCategoryResponse(
                    category.id,
                    category.categoryName,
                    category.subCategories.map { PerformanceSubCategoryResponse(it.id, it.subcategoryName) }
            )
        }
        val types = performerTypeRepository.findAll()
        val typeResponsesData = types.map {
            PerformerTypeResponse(
                    it.id,
                    it.typeName
            )
        }
        val styles = performerStyleRepository.findAll()
        val styleResponsesData = styles.map {
            PerformerStyleResponse(
                    it.id,
                    it.styleName
            )
        }

        return InfoResponse(typeResponsesData, styleResponsesData, categoryResponsesData)
    }
}