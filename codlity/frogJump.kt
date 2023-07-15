package codlity

// you can also use imports, for example:
// import kotlin.math.*

// you can write to stdout for debugging purposes, e.g.
// println("this is a debug message")

fun solution(X: Int, Y: Int, D: Int): Int {
    val distance = Y - X
    val atLeastCount = distance / D
    val hasRemainder = distance % D != 0

    return if (hasRemainder) atLeastCount + 1 else atLeastCount
}
