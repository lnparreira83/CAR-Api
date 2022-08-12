package com.lnp.car.interfaces.incoming

import com.lnp.car.domain.Driver
import com.lnp.car.domain.DriverRepository
import com.lnp.car.domain.PathDriver
import com.lnp.car.interfaces.copy
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.time.LocalDate

@Service
@RestController
@RequestMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
class DriverAPI (val driverRepository : DriverRepository) {

    @GetMapping("/drivers")
    fun listDrivers() = driverRepository.findAll()

    @GetMapping("/drivers/{id}")
    fun findDriver(@PathVariable("id") id: Long){
        driverRepository.findById(id)
            .orElseThrow {
                ResponseStatusException(HttpStatus.NOT_FOUND)
            }
    }

    @PostMapping("/drivers")
    fun createDriver(@RequestBody driver: Driver) : Driver {
        return driverRepository.save(driver)
    }

    @PutMapping("/drivers/{id}")
    fun fullUpdateDriver(@PathVariable("id") id: Long, @RequestBody driver: Driver) : Driver {
        val driverFound = driverRepository.findById(id)
        val driverUpdated = driverFound.get().copy(name = driver.name, birthDate = driver.birthDate)

        return driverRepository.save(driverUpdated)
    }

    @PatchMapping("/drivers/{id}")
    fun incrementalUpdateDriver(@PathVariable("id") id: Long, @RequestBody driver: PathDriver): Driver {
        val foundDriver = findDriver(id)
        val copyDriver = foundDriver.copy(
            birthDate = (driver.birthDate ?: foundDriver) as LocalDate,
            name = (driver.name ?: foundDriver) as String
        )
        return driverRepository.save(copyDriver)
    }

    @DeleteMapping("/drivers/{id}")
    fun deleteDriver(@PathVariable("id") id: Long) {
        driverRepository.deleteById(id)
    }
}