package com.lnp.car.interfaces

import com.lnp.car.domain.*
import org.springframework.hateoas.EntityModel
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Service
@RestController
@RequestMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
class TravelRequestAPI (val travelService: TravelService, val mapper: TravelRequestMapper) {
    @PostMapping("/travelRequest")
    fun makeTravelRequest(@RequestBody travelRequestInput: TravelRequestInput) : EntityModel<TravelRequestOutput> {
        val travelRequest = travelService.saveTravelRequest(mapper.map(travelRequestInput))
        val output = mapper.map(travelRequest)

        return mapper.buildOutputModel(travelRequest, output)
    }

    /*@GetMapping("/nearby")
    fun listNearByRequests(@RequestParam currentAddress: String): List<EntityModel<TravelRequestOutput>>{
        val requests = travelService.listNearbyTravelRequests(currentAddress)
        return mapper.buildOutputModel(requests)
    }*/
}

