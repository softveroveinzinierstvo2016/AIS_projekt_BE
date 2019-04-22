package sk.vildibald.polls.controller.impl

import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import sk.vildibald.polls.controller.InfoController
import sk.vildibald.polls.payload.*
import sk.vildibald.polls.service.InfoService

@RestController
@RequestMapping("/api")
class InfoControllerImpl (private val infoService: InfoService) : InfoController{

    @GetMapping("/signup")
    override fun allInfo(): InfoResponse {
        return infoService.allInfo()
    }
/*
    @GetMapping
    override fun allCategories(): List<PerformanceCategoryResponse> {
        return performanceCategoryService.allPerformanceCategories()
    }

    @GetMapping
    override fun allStyles(): List<PerformerStyleResponse> {
        return performerStyleService.allPerformerStyles()
    }

    @GetMapping
    override fun allTypes(): List<PerformerTypeResponse> {
        return performerTypeService.allPerformerTypes()
    }

    @GetMapping
    override fun allSubCategories(): List<PerformanceSubCategoryResponse> {
        return performanceSubCategoryService.allPerformanceSubCategories()
    }*/
}