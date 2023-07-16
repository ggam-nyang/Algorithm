package codlity

// you can also use imports, for example:
// import kotlin.math.*

// you can write to stdout for debugging purposes, e.g.
// println("this is a debug message")

private const val LIMIT = 1_000_000_000

private fun solution(A: IntArray): Int {
    var westCarCount = A.count { it == 1 }
    var answer = 0L

    A.forEach { direction ->
        if (direction ==  0) answer += westCarCount
        if (direction == 1) westCarCount -= 1

        if (westCarCount <= 0) return answer(answer)
    }

    return answer(answer)
}

private fun answer(value: Long): Int =
    if (value > LIMIT) -1 else value.toInt()
