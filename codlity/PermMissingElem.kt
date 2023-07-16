package codlity

// you can also use imports, for example:
// import kotlin.math.*

// you can write to stdout for debugging purposes, e.g.
// println("this is a debug message")

private fun solution(A: IntArray): Int {
    val size = A.size
    val sumOfOneTo = sumOfOneToN((size + 1).toLong())
    val sumOfA = A.sumOf { it.toLong() }

    return (sumOfOneTo - sumOfA).toInt()
}

private fun sumOfOneToN(n: Long): Long = n * (n + 1) / 2
