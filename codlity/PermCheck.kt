package codlity

// you can also use imports, for example:
// import kotlin.math.*

// you can write to stdout for debugging purposes, e.g.
// println("this is a debug message")

private fun solution(A: IntArray): Int {
    val size = A.size
    if (A.toSet().size != size) return 0

    val expect = sumOfOneToN(size)
    val actual = A.sum()

    return if (expect == actual) 1 else 0
}

private fun sumOfOneToN(n: Int) = n * (n + 1) / 2
