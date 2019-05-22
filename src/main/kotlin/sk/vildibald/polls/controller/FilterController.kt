package sk.vildibald.polls.controller

import org.springframework.http.ResponseEntity
import sk.vildibald.polls.payload.FilterRequest
import sk.vildibald.polls.payload.FilterResponse
import sk.vildibald.polls.payload.LoginRequest
import sk.vildibald.polls.payload.SignUpRequest

interface FilterController{

    fun filter(filterRequest: FilterRequest): FilterResponse
}