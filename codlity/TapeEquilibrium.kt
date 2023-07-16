package codlity

import kotlin.math.abs
import kotlin.math.min

// you can also use imports, for example:
// import kotlin.math.*

// you can write to stdout for debugging purposes, e.g.
// println("this is a debug message")

private fun solution(A: IntArray): Int {
    var leftSum = 0
    var rightSum = A.sum()
    var diff = Int.MAX_VALUE

    (0 until A.size - 1).forEach { i ->
        leftSum += A[i]
        rightSum -= A[i]
        diff = min(diff, abs(leftSum - rightSum))
    }

    return diff
}
