package sk.vildibald.polls.service.impl

import org.springframework.stereotype.Service
import sk.vildibald.polls.mapping.PerformanceSubCategoryConverter
import sk.vildibald.polls.payload.InfoResponse
import sk.vildibald.polls.payload.PerformanceCategoryResponse
import sk.vildibald.polls.payload.PerformerStyleResponse
import sk.vildibald.polls.payload.PerformerTypeResponse
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
        val categoryResponsesData = categories.map { performanceCategory ->
            PerformanceCategoryResponse(
                    performanceCategory.id,
                    performanceCategory.categoryName,
                    performanceCategory.subCategories.map(PerformanceSubCategoryConverter()::convert)
            )
        }
        val types = performerTypeRepository.findAll()
        val typeResponsesData = types.map { perfomerType ->
            PerformerTypeResponse(
                    perfomerType.id,
                    perfomerType.typeName
            )
        }
        val styles = performerStyleRepository.findAll()
        val styleResponsesData = styles.map { perfomerStyle ->
            PerformerStyleResponse(
                    perfomerStyle.id,
                    perfomerStyle.styleName
            )
        }

        return InfoResponse(typeResponsesData,styleResponsesData,categoryResponsesData)
    }
}