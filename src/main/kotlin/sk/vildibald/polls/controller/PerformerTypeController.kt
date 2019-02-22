package sk.vildibald.polls.controller

import sk.vildibald.polls.payload.PerformerTypeResponse
import sk.vildibald.polls.security.UserPrincipal

interface PerformerTypeController {

    fun allTypes():
            List<PerformerTypeResponse>
}