package com.lnp.car.interfaces

import com.lnp.car.domain.TravelRequest
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Service
@RestController
@RequestMapping(produces = [org.springframework.http.MediaType.APPLICATION_JSON_VALUE])
class TravelRequestAPI {
    @PostMapping
    fun makeTravelRequest(@RequestBody travelRequest: TravelRequest){

    }
}