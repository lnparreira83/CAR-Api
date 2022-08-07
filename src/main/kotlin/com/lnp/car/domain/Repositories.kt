package com.lnp.car.domain

import org.springframework.data.jpa.repository.JpaRepository

interface DriverRepository : JpaRepository <Driver, Long>

interface PassengerRepository : JpaRepository<Passenger, Long>

public interface TravelRequestRepository : JpaRepository<TravelRequest,Long>