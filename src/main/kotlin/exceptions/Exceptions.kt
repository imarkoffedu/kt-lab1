package org.imarkoff.lab1.exceptions

class RoomNotAvailableException(message: String) : Exception(message) {
    constructor() : this("Room is temporarily unavailable or already booked for the selected dates")
}