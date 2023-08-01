package baekjoon.tony.data_structure2

import java.util.PriorityQueue
import kotlin.math.absoluteValue

fun main() {
    val N = readln().toInt()

    val pq = PriorityQueue<AbsValue1>()
    for (i in 1 .. N) {
        val input = readln().toInt()

        if (input == 0) {
            if (pq.isEmpty()) println(0)
            else println(pq.poll().value)
        }
        else
            pq.add(AbsValue1(input, input.absoluteValue))
    }
}

data class AbsValue(
    val value: Int,
    val absValue: Int
) : Comparable<AbsValue1> {
    override fun compareTo(other: AbsValue1): Int {
        return if (this.absValue != other.absValue) this.absValue - other.absValue
        else this.value - other.value
    }
}