package sk.vildibald.polls.controller.impl

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import sk.vildibald.polls.controller.PerformerStyleController
import sk.vildibald.polls.payload.PerformerStyleResponse
import sk.vildibald.polls.security.UserPrincipal
import sk.vildibald.polls.service.PerformerStyleService

@RestController
@RequestMapping("/api/styles")
class PerformerStyleControllerImpl (private val performerStyleService: PerformerStyleService) : PerformerStyleController{

    @GetMapping
    override fun allStyles(): List<PerformerStyleResponse> {
        return performerStyleService.allPerformerStyles()
    }
}