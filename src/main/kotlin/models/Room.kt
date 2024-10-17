package org.imarkoff.lab1.models

import org.imarkoff.lab1.exceptions.RoomNotAvailableException
import java.util.*

class Room (
    val roomType: String,
    val pricePerNight: Float
) {
    val roomId: UUID = UUID.randomUUID()
    val bookings: MutableList<Booking> = mutableListOf()

    fun checkAvailability(startDate: Date, endDate: Date): Boolean =
        bookings.none { booking ->
            startDate.before(booking.endDate) && endDate.after(booking.startDate) && !booking.isCancelled
        }

    fun book(booking: Booking) {
        if (!checkAvailability(booking.startDate, booking.endDate))
            throw RoomNotAvailableException()

        bookings.add(booking)
    }

}