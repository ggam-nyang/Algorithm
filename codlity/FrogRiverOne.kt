package codlity

// you can also use imports, for example:
// import kotlin.math.*

// you can write to stdout for debugging purposes, e.g.
// println("this is a debug message")

private fun solution(X: Int, A: IntArray): Int {
    val size = A.size
    if (size < X) return -1

    val isLeaf = BooleanArray(size + 1)
    var sumOfLeftPosition = sumOfOneToN(X)

    A.forEachIndexed { index, position ->
        if (!isLeaf[position]) {
            isLeaf[position] = true
            sumOfLeftPosition -= position

            if (sumOfLeftPosition == 0) return index
        }
    }

    return -1
}

private fun sumOfOneToN(n: Int) = n * (n + 1) / 2
