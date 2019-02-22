package sk.vildibald.polls.mapping

import org.springframework.core.convert.converter.Converter
import sk.vildibald.polls.model.PerformanceSubCategory
import sk.vildibald.polls.payload.PerformanceSubCategoryResponse

class PerformanceSubCategoryConverter : Converter<PerformanceSubCategory, PerformanceSubCategoryResponse> {

    override fun convert(source: PerformanceSubCategory): PerformanceSubCategoryResponse =
            PerformanceSubCategoryResponse(id = source.id,
                    subCategoryName = source.subcategoryName
            )
}