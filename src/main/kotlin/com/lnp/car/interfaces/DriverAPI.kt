package com.lnp.car.interfaces

import com.lnp.car.domain.Driver
import com.lnp.car.domain.DriverRepository
import com.lnp.car.domain.PathDriver
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.stereotype.Service
import org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.time.LocalDate

fun Unit.copy(birthDate: LocalDate, name: String): Driver {
    return Driver(birthDate = birthDate, name = name)
}
