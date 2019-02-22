package sk.vildibald.polls.service

import sk.vildibald.polls.payload.InfoResponse

interface InfoService {
    fun allInfo()
            : InfoResponse
}