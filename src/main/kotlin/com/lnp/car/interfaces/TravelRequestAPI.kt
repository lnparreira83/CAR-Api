package com.lnp.car.interfaces

import com.lnp.car.domain.TravelRequest
import com.lnp.car.domain.TravelRequestInput
import com.lnp.car.domain.TravelRequestMapper
import com.lnp.car.domain.TravelService
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Service
@RestController
@RequestMapping(produces = [org.springframework.http.MediaType.APPLICATION_JSON_VALUE])
class TravelRequestAPI (val travelService: TravelService, val mapper: TravelRequestMapper) {
    @PostMapping
    fun makeTravelRequest(@RequestBody travelRequestInput: TravelRequestInput){
        travelService.saveTravelRequest(mapper.map(travelRequestInput))
    }
}

