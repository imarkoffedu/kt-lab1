package org.imarkoff.lab1.models

import java.util.UUID

class Admin {
    val adminId: UUID = UUID.randomUUID()
    var name: String = ""

    fun viewAllBookings(hotel: Hotel): List<Booking> {
        return hotel.bookings
    }

    fun cancelBooking(hotel: Hotel, booking: Booking) {
        hotel.cancelBooking(booking)
    }
}