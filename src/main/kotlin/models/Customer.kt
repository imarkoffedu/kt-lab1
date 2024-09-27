package org.imarkoff.lab1.models

import java.util.*

class Customer {
    val customerId: UUID = UUID.randomUUID()
    var name: String = ""
    var email: String = ""
    val bookings: MutableList<Booking> = mutableListOf()

    fun makeBooking(hotel: Hotel, room: Room, startDate: Date, endDate: Date) {
        hotel.makeBooking(this, room, startDate, endDate)
    }

    fun cancelBooking(hotel: Hotel, booking: Booking) {
        bookings.remove(booking)
        hotel.cancelBooking(booking)
    }

    fun viewBookings(): List<Booking> {
        return bookings
    }
}