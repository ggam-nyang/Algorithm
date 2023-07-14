package codlity

// you can also use imports, for example:
// import kotlin.math.*

// you can write to stdout for debugging purposes, e.g.
// println("this is a debug message")

fun solution(A: IntArray, K: Int): IntArray {
    val size = A.size
    if (size == 0) return A

    val k = K % size
    val rotatedList = A.takeLast(k) + A.take(size - k)

    return rotatedList.toIntArray()
}
