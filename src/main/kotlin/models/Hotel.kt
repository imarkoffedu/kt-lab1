package org.imarkoff.lab1.models

import java.util.Date

class Hotel {
    val rooms: MutableList<Room> = mutableListOf()
    val bookings: MutableList<Booking> = mutableListOf()

    fun addRoom(room: Room) {
        rooms.add(room)
    }

    fun findAvailableRoom(startDate: Date, endDate: Date, roomType: String): Boolean {
        rooms.forEach { room ->
            if (room.roomType == roomType) {
                return room.checkAvailability()
            }
        }

        return false
    }

    fun makeBooking(customer: Customer, room: Room, startDate: Date, endDate: Date) {
        val booking = Booking().apply {
            this.customer = customer
            this.room = room
            this.startDate = startDate
            this.endDate = endDate
        }

        bookings.add(booking)
        room.markAsBooked()
    }

    fun cancelBooking(booking: Booking) {
        booking.cancelBooking()
        bookings.remove(booking)
    }
}