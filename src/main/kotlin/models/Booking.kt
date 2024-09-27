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

    data class BookingDetails(
        val customer: Customer,
        val room: Room,
        val startDate: Date,
        val endDate: Date,
        val isCancelled: Boolean
    )

    fun getBookingDetails(): BookingDetails {
        return BookingDetails(
            customer = customer,
            room = room,
            startDate = startDate,
            endDate = endDate,
            isCancelled = isCancelled
        )
    }

    fun cancelBooking() {
        room.markAsAvailable()
        isCancelled = true
    }
}