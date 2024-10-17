package org.imarkoff.lab1.models

import java.util.*

class Booking (
    val customer: Customer,
    val room: Room,
    val startDate: Date,
    val endDate: Date,
) {
    val bookingId: UUID = UUID.randomUUID()
    var isCancelled: Boolean = false

    fun cancelBooking() { isCancelled = true }
}