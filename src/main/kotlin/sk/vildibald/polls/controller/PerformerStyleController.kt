package sk.vildibald.polls.controller

import sk.vildibald.polls.payload.PerformerStyleResponse
import sk.vildibald.polls.security.UserPrincipal


interface PerformerStyleController {

    fun allStyles():
            List<PerformerStyleResponse>
}