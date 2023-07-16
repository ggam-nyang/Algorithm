package codlity

// you can also use imports, for example:
// import kotlin.math.*

// you can write to stdout for debugging purposes, e.g.
// println("this is a debug message")

private fun solution(A: IntArray): Int {
    var answer = 1

    var currentIndex = 0
    while (answer < A.size) {
        if (A[currentIndex] == -1) return answer
        answer++
        currentIndex = A[currentIndex]
    }

    return answer
}
