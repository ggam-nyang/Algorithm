package codlity.test

// you can also use imports, for example:
// import kotlin.math.*

// you can write to stdout for debugging purposes, e.g.
// println("this is a debug message")

fun solution(S: String): Boolean {
    val a = 'a'
    val b = 'b'

    val lastIndexOfA = S.lastIndexOf(a)
    val firstIndexOfB = S.indexOf(b)

    if (lastIndexOfA == -1 || firstIndexOfB == -1) return true
    if (lastIndexOfA < firstIndexOfB) return true

    return false
}
