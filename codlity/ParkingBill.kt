package codlity

// you can also use imports, for example:
// import kotlin.math.*

// you can write to stdout for debugging purposes, e.g.
// println("this is a debug message")

fun solution(E: String, L: String): Int {
    val (entryTime, entryMinute) = E.split(":").map { it.toInt() }
    val (exitTime, exitMinute) = L.split(":").map { it.toInt() }

    var remainTime = exitTime - entryTime
    var remainMinute = exitMinute - entryMinute

    if (remainMinute < 0) {
        remainTime--
        remainMinute += 60
    }
    if (remainMinute > 0) remainTime++

    return 2 + remainTime * 4 - 1
}
