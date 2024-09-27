package org.imarkoff.lab1.models

import java.util.*

class Booking {
    val bookingId: UUID = UUID.randomUUID()
    var customer: Customer = Customer()
    var room: Room = Room()
    var startDate: Date? = Date()
    var endDate: Date? = Date()

    data class BookingDetails(
        val customer: Customer,
        val room: Room,
        val startDate: Date?,
        val endDate: Date?
    )

    fun getBookingDetails(): BookingDetails {
        return BookingDetails(
            customer = customer,
            room = room,
            startDate = startDate,
            endDate = endDate
        )
    }

    fun cancelBooking() {
        room.markAsAvailable()
    }
}