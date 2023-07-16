package codlity

import kotlin.math.min

// you can also use imports, for example:
// import kotlin.math.*

// you can write to stdout for debugging purposes, e.g.
// println("this is a debug message")

fun solution(P: Int, C: Int): Int {
    val playerPerCourt = 2

    val needCourtSize = P / playerPerCourt
    return min(needCourtSize, C)
}
