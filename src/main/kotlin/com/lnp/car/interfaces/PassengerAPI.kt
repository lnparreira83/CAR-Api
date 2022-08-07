package com.lnp.car.interfaces

import com.lnp.car.domain.Passenger
import com.lnp.car.domain.PassengerRepository
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@Service
@RestController
@RequestMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
class PassengerAPI (val passengerRepository : PassengerRepository) {

    @GetMapping("/passengers")
    fun listPassengers() = passengerRepository.findAll()

    @GetMapping("/passengers/{id}")
    fun findPassenger(@PathVariable("id") id: Long) = passengerRepository.findById(id)
        .orElseThrow {
            ResponseStatusException(HttpStatus.NOT_FOUND)
        }

    @PostMapping("/passengers")
    fun createPassenger(@RequestBody passenger: Passenger) = passengerRepository.save(passenger)

    @PutMapping("/passengers/{id}")
    fun fullUpdatePassenger(@PathVariable("id") id: Long, @RequestBody passenger: Passenger) : Passenger {
        val newPassenger = findPassenger(id).copy(
            name = passenger.name
        )
        return passengerRepository.save(newPassenger)
    }

    @PatchMapping("/passengers/{id}")
    fun incrementalUpdatePassenger(@PathVariable("id") id: Long, @RequestBody passenger: Passenger) : Passenger {
        val foundPassenger = findPassenger(id)
        val newPassenger = foundPassenger.copy(
            name = passenger.name ?: foundPassenger.name
        )
        return passengerRepository.save(newPassenger)
    }

    @DeleteMapping("/passengers/{id}")
    fun deletePassenger(@PathVariable("id") id: Long) = passengerRepository.delete(findPassenger(id))

    data class PatchPassenger(
        val name: String?
    )
}