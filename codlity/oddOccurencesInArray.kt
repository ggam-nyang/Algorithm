package codlity

// you can also use imports, for example:
// import kotlin.math.*

// you can write to stdout for debugging purposes, e.g.
// println("this is a debug message")

// low performance
fun failedSolution(A: IntArray): Int {
    return A
        .groupBy{ it }
        .filterNot { it.value.size % 2 == 0 }
        .entries
        .first()
        .key
}

// 1 testcase failed
fun failedSolution2(A: IntArray): Int {
    val set = hashSetOf<Int>()
    A.forEach {
        if (set.contains(it)) set.remove(it)
        else set.add(it)
    }

    return set.first()
}

fun solution(A: IntArray): Int {
    var answer = 0

    A.forEach { answer = it xor answer }
    return answer
}

