package org.imarkoff.lab1.models

import java.util.*

class Customer(
    val name: String,
    val phone: String,
    val email: String? = null
) {
    val customerId: UUID = UUID.randomUUID()
    private val bookings: MutableList<Booking> = mutableListOf()

    fun makeBooking(hotel: Hotel, room: Room, startDate: Date, endDate: Date): Booking {
        val booking = hotel.makeBooking(this, room, startDate, endDate)
        bookings.add(booking)
        return booking
    }

    fun viewBookings(): List<Booking> = bookings
}