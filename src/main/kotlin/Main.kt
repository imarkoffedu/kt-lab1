package org.imarkoff.lab1

import org.imarkoff.lab1.exceptions.RoomNotAvailableException
import org.imarkoff.lab1.models.Booking
import org.imarkoff.lab1.models.Customer
import org.imarkoff.lab1.models.Hotel
import org.imarkoff.lab1.models.Room
import java.util.Calendar

fun prettyBookings(bookings: List<Booking>) {
    bookings.forEach { booking ->
        println("Booking ID: ${booking.bookingId}")
        println("Room type: ${booking.room.roomType}")
        println("Room ID: ${booking.room.roomId}")
        println("Start date: ${booking.startDate}")
        println("End date: ${booking.endDate}")
        println("Is cancelled: ${booking.isCancelled}")
        println("--------------------")
    }
    println()
}

fun prettyRooms(rooms: List<Room>) {
    rooms.forEach { room ->
        println("Room type: ${room.roomType}")
        println("Price per night: ${room.pricePerNight}")
        println("--------------------")
    }
}

fun main() {
    val hazbinHotel = Hotel("Hazbin Hotel", "Hell, 666")
    hazbinHotel.addRoom(Room("Single", 666.0f))
    hazbinHotel.addRoom(Room("Double", 999.0f))
    hazbinHotel.addRoom(Room("Single", 636.0f))
    hazbinHotel.addRoom(Room("Doom", 9999.0f))
    hazbinHotel.addRoom(Room("Hell", 66666.0f))
    hazbinHotel.addRoom(Room("Heaven", 99999.0f))

    val john = Customer("John Doe", "666-666-6666")
    val jane = Customer("Jane Doe", "999-999-9999", "janedoe@example.com")

    val calendar = Calendar.getInstance()
    calendar.set(2024, 10, 17)
    var startDate = calendar.time
    calendar.set(2024, 10, 24)
    var endDate = calendar.time

    val singleRoom = hazbinHotel.availableRooms(startDate, endDate, "Single").first()
    john.makeBooking(hazbinHotel, singleRoom, startDate, endDate)
    println("John booked a single room from $startDate to $endDate.")

    val doubleRoom = hazbinHotel.availableRooms(startDate, endDate).filter { it.roomType == "Double" }.first()
    jane.makeBooking(hazbinHotel, doubleRoom, startDate, endDate)
    println("Jane booked a double room from $startDate to $endDate.\n")

    val johnsRoom2 = hazbinHotel.availableRooms(startDate, endDate, "Double").firstOrNull()
    if (johnsRoom2 != null) {
        john.makeBooking(hazbinHotel, johnsRoom2, startDate, endDate)
    }
    else {
        println("John wanted to book a Double room, but there were none available.\n")
    }

    calendar.set(2024, 10, 18)
    startDate = calendar.time
    calendar.set(2024, 10, 25)
    endDate = calendar.time

    val isRoomAvailable = singleRoom.checkAvailability(startDate, endDate)
    println("Is John's room available from $startDate to $endDate? $isRoomAvailable\n")

    try {
        jane.makeBooking(hazbinHotel, singleRoom, startDate, endDate)
    }
    catch (e: RoomNotAvailableException) {
        println("Jane tried to book single room, but hotel said the following.")
        println("${e.message} \n")
    }

    calendar.set(2024, 10, 25)
    startDate = calendar.time
    calendar.set(2024, 10, 26)
    endDate = calendar.time

    val janesBooking2 = jane.makeBooking(hazbinHotel, singleRoom, startDate, endDate)

    println("John's bookings:")
    prettyBookings(john.viewBookings())
    println("Jane's bookings:")
    prettyBookings(jane.viewBookings())

    janesBooking2.cancelBooking()
    println("Jane cancelled her last booking.\n")

    john.makeBooking(hazbinHotel, singleRoom, startDate, endDate)

    println("John's bookings:")
    prettyBookings(john.viewBookings())
    println("Jane's bookings:")
    prettyBookings(jane.viewBookings())

    calendar.set(2024, 10, 17)
    startDate = calendar.time

    println("Available rooms from $startDate to $endDate:")
    prettyRooms(hazbinHotel.availableRooms(startDate, endDate))
}