package com.lnp.car.domain

import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Driver(
    @Id
    @GeneratedValue
    var id: Long? = null,
    var name: String,
    var birthDate: LocalDate
)