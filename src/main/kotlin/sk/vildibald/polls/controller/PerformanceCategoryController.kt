package sk.vildibald.polls.controller

import sk.vildibald.polls.payload.PerformanceCategoryResponse
import sk.vildibald.polls.security.UserPrincipal

interface PerformanceCategoryController {

    fun allCategories():
            List<PerformanceCategoryResponse>
}