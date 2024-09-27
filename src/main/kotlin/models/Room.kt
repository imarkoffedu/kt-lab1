package org.imarkoff.lab1.models

import java.util.*

class Room {
    val roomId: UUID = UUID.randomUUID()
    var roomType: String = ""
    var pricePerNight: Double = 0.0
    var isAvailable: Boolean = true

    fun checkAvailability(): Boolean {
        return isAvailable
    }

    fun markAsBooked() {
        isAvailable = false
    }

    fun markAsAvailable() {
        isAvailable = true
    }
}