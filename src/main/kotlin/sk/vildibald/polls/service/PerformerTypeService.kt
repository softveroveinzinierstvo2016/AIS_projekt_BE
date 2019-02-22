package sk.vildibald.polls.service

import sk.vildibald.polls.payload.PagedResponse
import sk.vildibald.polls.payload.PerformerTypeResponse
import sk.vildibald.polls.security.UserPrincipal

interface PerformerTypeService {

    fun allPerformerTypes()
            : List<PerformerTypeResponse>

}