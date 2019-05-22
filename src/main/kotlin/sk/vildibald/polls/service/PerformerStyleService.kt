package sk.vildibald.polls.service

import sk.vildibald.polls.payload.PerformerStyleResponse

interface PerformerStyleService {

    fun allPerformerStyles(): List<PerformerStyleResponse>
}