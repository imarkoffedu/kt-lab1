package org.imarkoff.lab1.models

import java.util.*

class Room (
    val roomType: String,
    val pricePerNight: Double
) {
    val roomId: UUID = UUID.randomUUID()
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