package com.lnp.car.domain

data class TravelRequestInput (
    val passengerId: Long,
    val origin: String,
    val destination: String
    )