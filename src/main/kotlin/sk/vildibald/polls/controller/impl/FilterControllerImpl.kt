package sk.vildibald.polls.controller.impl

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import sk.vildibald.polls.controller.FilterController
import sk.vildibald.polls.payload.FilterRequest
import sk.vildibald.polls.payload.FilterResponse
import sk.vildibald.polls.service.FilterService
import javax.validation.Valid


@RestController
@RequestMapping("/api")
class FilterControllerImpl(
        private val filterService : FilterService
) : FilterController {

    @PostMapping("/filter")
    override fun filter(@Valid @RequestBody filterRequest: FilterRequest): FilterResponse {
        return filterService.filter(filterRequest)
    }
}