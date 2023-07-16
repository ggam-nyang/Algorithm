package codlity.test

// you can also use imports, for example:
// import kotlin.math.*

// you can write to stdout for debugging purposes, e.g.
// println("this is a debug message")

fun solution(S: String, A: IntArray): String {
    val answer = StringBuilder(A.size)
    answer.append(S.first().toString())

    var currIndex = A[0]
    while (answer.length < A.size && currIndex != 0) {
        answer.append(S[currIndex])
        currIndex = A[currIndex]
    }

    return answer.toString()
}
