package org.imarkoff.lab1.models

import java.util.UUID

class Admin (
    val name: String,
) {
    val adminId: UUID = UUID.randomUUID()

    fun viewAllBookings(hotel: Hotel): List<Booking> {
        return hotel.bookings
    }

    fun cancelBooking(hotel: Hotel, booking: Booking) {
        hotel.cancelBooking(booking)
    }
}