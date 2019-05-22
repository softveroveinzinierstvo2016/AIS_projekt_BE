package sk.vildibald.polls.service

import sk.vildibald.polls.payload.PerformanceCategoryResponse

interface PerformanceCategoryService {

    fun allPerformanceCategories(): List<PerformanceCategoryResponse>
}