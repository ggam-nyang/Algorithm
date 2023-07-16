package codlity

// you can also use imports, for example:
// import kotlin.math.*

// you can write to stdout for debugging purposes, e.g.
// println("this is a debug message")

private fun solution(A: Int, B: Int, K: Int): Int {
    val diff = B - A
    val leftRemainder = A % K
    val rightRemainder = B % K

    val answer = ((B - rightRemainder) - (A + K - leftRemainder)) / K + 1

    return if (leftRemainder == 0) answer + 1 else answer
}
