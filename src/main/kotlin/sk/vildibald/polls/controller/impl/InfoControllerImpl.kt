package sk.vildibald.polls.controller.impl

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
}