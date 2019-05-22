package sk.vildibald.polls.controller.impl

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import sk.vildibald.polls.controller.PerformanceCategoryController
import sk.vildibald.polls.payload.PerformanceCategoryResponse
import sk.vildibald.polls.security.UserPrincipal
import sk.vildibald.polls.service.PerformanceCategoryService

@RestController
@RequestMapping("/api/categories")
class PerformanceCategoryControllerImpl (
        private val performanceCategoryService: PerformanceCategoryService
) : PerformanceCategoryController {

    @GetMapping
    override fun allCategories() = performanceCategoryService.allPerformanceCategories()

}