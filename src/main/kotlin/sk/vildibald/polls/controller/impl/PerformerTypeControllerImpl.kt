package sk.vildibald.polls.controller.impl

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import sk.vildibald.polls.controller.PerformerTypeController
import sk.vildibald.polls.payload.PerformerTypeResponse
import sk.vildibald.polls.security.UserPrincipal
import sk.vildibald.polls.service.PerformerTypeService

@RestController
@RequestMapping("/api/types")
class PerformerTypeControllerImpl (private val performerTypeService: PerformerTypeService) : PerformerTypeController{

    @GetMapping
    override fun allTypes(): List<PerformerTypeResponse> {
        return performerTypeService.allPerformerTypes()
    }
}