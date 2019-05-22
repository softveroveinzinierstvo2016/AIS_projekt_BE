package sk.vildibald.polls.service.impl

import org.springframework.stereotype.Service
import sk.vildibald.polls.payload.PerformanceCategoryResponse
import sk.vildibald.polls.payload.PerformanceSubCategoryResponse
import sk.vildibald.polls.repository.PerformanceCategoryRepository
import sk.vildibald.polls.service.PerformanceCategoryService

@Service
class PerformanceCategoryServiceImpl(private val performerCategoryRepository: PerformanceCategoryRepository) : PerformanceCategoryService {

    override fun allPerformanceCategories(): List<PerformanceCategoryResponse> =
            performerCategoryRepository.findAll().map { it ->
                PerformanceCategoryResponse(
                        it.id,
                        it.categoryName,
                        it.subCategories.map { PerformanceSubCategoryResponse(it.id, it.subcategoryName) }
                )
            }
}