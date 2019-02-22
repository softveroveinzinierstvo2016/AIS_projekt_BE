package sk.vildibald.polls.service.impl

import org.springframework.stereotype.Service
import sk.vildibald.polls.mapping.PerformanceSubCategoryConverter
import sk.vildibald.polls.payload.PerformanceCategoryResponse
import sk.vildibald.polls.repository.PerformanceCategoryRepository
import sk.vildibald.polls.security.UserPrincipal
import sk.vildibald.polls.service.PerformanceCategoryService

@Service
class PerformanceCategoryServiceImpl(private val performerCategoryRepository: PerformanceCategoryRepository) : PerformanceCategoryService{

    override fun allPerformanceCategories(): List<PerformanceCategoryResponse> {
        val categories = performerCategoryRepository.findAll()



        val categoryResponsesData = categories.map { performanceCategory ->
            PerformanceCategoryResponse(
                    performanceCategory.id,
                    performanceCategory.categoryName,
                    performanceCategory.subCategories.map { performanceSubCategory ->
                        PerformanceSubCategoryConverter().convert(performanceSubCategory)
                    }
            )
        }

        return categoryResponsesData
    }
}