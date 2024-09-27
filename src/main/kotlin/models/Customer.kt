package org.imarkoff.lab1.models

import java.util.*

class Customer(
    val name: String,
    val phone: String,
    val email: String? = null
) {
    val customerId: UUID = UUID.randomUUID()
    val bookings: MutableList<Booking> = mutableListOf()

    fun makeBooking(hotel: Hotel, room: Room, startDate: Date, endDate: Date) {
        hotel.makeBooking(this, room, startDate, endDate)
    }

    fun cancelBooking(hotel: Hotel, booking: Booking) {
        hotel.cancelBooking(booking)
    }

    fun viewBookings(): List<Booking> {
        return bookings
    }
}