package codlity

import kotlin.math.max

// you can also use imports, for example:
// import kotlin.math.*

// you can write to stdout for debugging purposes, e.g.
// println("this is a debug message")

fun solution(N: Int): Int {
    val binaryString = N.toString(2)

    var maxBinaryGap = 0
    var tempBinaryGap = 0
    (1 until binaryString.length).forEach {
        if (binaryString[it] == '0') tempBinaryGap++
        else {
            maxBinaryGap = max(maxBinaryGap, tempBinaryGap)
            tempBinaryGap = 0
        }
    }

    return maxBinaryGap
}
