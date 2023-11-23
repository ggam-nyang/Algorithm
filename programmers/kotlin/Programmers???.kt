package programmers.kotlin

import java.lang.Integer.max
import java.util.PriorityQueue

class `Programmers???` {
    fun solution(book_time: Array<Array<String>>): Int {
        val bookings = book_time.map { aBooking ->
            aBooking.map { Booking.fromString(it) }
        }

        var maxRoom = 0

        val sortedBookings = bookings.sortedBy {
            it.first()
        }

        val queue = PriorityQueue<Booking>()

        sortedBookings.forEach { booking ->
            booking.first().minute -= 10
            while (queue.isNotEmpty()) {
                if (queue.peek() <= booking.first()) {
                    queue.poll()
                } else {
                    queue.add(booking.last())
                }
                maxRoom = max(maxRoom, queue.size)
            }
        }

        return maxRoom
    }
}

data class Booking(
    val time: Int,
    var minute: Int
) : Comparable<Booking> {
    companion object {
        fun fromString(time: String): Booking {
            val (t, m) = time.split(":")

            return Booking(t.toInt(), m.toInt())
        }
    }

    override fun compareTo(other: Booking): Int {
        return if (this.time > other.time) 1
        else if (this.time < other.time) -1
        else {
            if (this.minute >= other.time) 1
            else -1
        }
    }
}