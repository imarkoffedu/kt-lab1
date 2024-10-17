package org.imarkoff.lab1.models

import java.util.Date
import java.util.UUID

class Hotel (
    val name: String,
    val address: String
) {
    val hotelId: UUID = UUID.randomUUID()
    private val rooms: MutableList<Room> = mutableListOf()

    fun addRoom(room: Room) { rooms.add(room) }

    fun availableRooms(startDate: Date, endDate: Date, roomType: String? = null): List<Room> =
        rooms.filter {room ->
            (roomType == null || room.roomType == roomType)
                    && room.checkAvailability(startDate, endDate)
        }

    fun makeBooking(customer: Customer, room: Room, startDate: Date, endDate: Date): Booking {
        val booking = Booking(
            customer,
            room,
            startDate,
            endDate
        )

        room.book(booking)
        return booking
    }

    fun cancelBooking(booking: Booking) { booking.cancelBooking() }
}