package com.lnp.car.domain

class TravelService (val travelRequestRepository: TravelRequestRepository) {
    fun saveTravelRequest(travelRequest: TravelRequest) = travelRequestRepository.save(travelRequest)
}