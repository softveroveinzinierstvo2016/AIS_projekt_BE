package sk.vildibald.polls.service

import sk.vildibald.polls.payload.PerformerTypeResponse

interface PerformerTypeService {

    fun allPerformerTypes(): List<PerformerTypeResponse>

}