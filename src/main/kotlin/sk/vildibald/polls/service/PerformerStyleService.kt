package sk.vildibald.polls.service

import sk.vildibald.polls.payload.PagedResponse
import sk.vildibald.polls.payload.PerformerStyleResponse
import sk.vildibald.polls.security.UserPrincipal

interface PerformerStyleService {

    fun allPerformerStyles()
            : List<PerformerStyleResponse>
}