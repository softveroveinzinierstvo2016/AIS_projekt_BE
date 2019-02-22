package sk.vildibald.polls.mapping

import org.springframework.core.convert.converter.Converter
import sk.vildibald.polls.model.PerformanceCategory
import sk.vildibald.polls.payload.PerformanceCategoryResponse

class PerformanceCategoryConverter : Converter<PerformanceCategory, PerformanceCategoryResponse> {

    override fun convert(source: PerformanceCategory): PerformanceCategoryResponse =
            PerformanceCategoryResponse(id = source.id,
                    categoryName = source.categoryName,
                    subCategories = source.subCategories.map{ PerformanceSubCategoryConverter().convert(it) }
            )
}