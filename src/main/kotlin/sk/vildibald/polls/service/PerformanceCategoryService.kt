package sk.vildibald.polls.service

import sk.vildibald.polls.payload.PagedResponse
import sk.vildibald.polls.payload.PerformanceCategoryResponse
import sk.vildibald.polls.security.UserPrincipal

interface PerformanceCategoryService {

    fun allPerformanceCategories()
            : List<PerformanceCategoryResponse>
}