package com.lnp.car.domain

import org.springframework.stereotype.Component

@Component
class TravelService (val travelRequestRepository: TravelRequestRepository) {
    fun saveTravelRequest(travelRequest: TravelRequest) = travelRequestRepository.save(travelRequest)

    /*fun listNearbyTravelRequests(currentAddress: String) : List<TravelRequest>{
        val requests = travelRequestRepository.findByStatus(TravelRequestStatus.CREATED)

        return requests.filter {
            travelRequest ->
            gMapsService
                .getDistanceBetweenAddress(currentAddress, travelRequest.origin) < MAX_TRAVEL_TIME
        }
    }*/
}