package sk.vildibald.polls.service

import sk.vildibald.polls.payload.FilterRequest
import sk.vildibald.polls.payload.FilterResponse

interface FilterService {

    fun filter(filterRequest: FilterRequest): FilterResponse
}