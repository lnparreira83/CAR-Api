package com.lnp.car.domain

import java.time.LocalDateTime

data class TravelRequestOutput (
    val id: Long,
    val origin: String,
    val destination: String,
    val status: TravelRequestStatus,
    val creationDate: LocalDateTime
        )