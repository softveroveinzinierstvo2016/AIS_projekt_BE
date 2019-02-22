package sk.vildibald.polls.controller

import sk.vildibald.polls.payload.*

interface InfoController {

    fun allInfo():
            InfoResponse
}