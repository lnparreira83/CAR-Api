package com.lnp.car.domain

import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

class TravelRequestMapper(val passengerRepository: PassengerRepository) {
    fun map(input: TravelRequestInput) : TravelRequest {
        val passenger = passengerRepository.findById(input.passengerId)
            .orElseThrow {
                ResponseStatusException(HttpStatus.NOT_FOUND)
            }
        return TravelRequest(passenger = passenger, origin = input.origin, destination = input.destination)
    }

    fun map(travelRequest: TravelRequest): TravelRequestOutput {
        return TravelRequestOutput(
            id = travelRequest.id!!,
            origin = travelRequest.origin,
            destination = travelRequest.destination,
            status = travelRequest.status,
            creationDate = travelRequest.creationDate
        )
    }
}