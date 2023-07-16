package codlity

// you can also use imports, for example:
// import kotlin.math.*

// you can write to stdout for debugging purposes, e.g.
// println("this is a debug message")

private fun solution(A: IntArray): Int {
    val indexMap = hashMapOf<Int, Int>()
    val countMap = hashMapOf<Int, Int>()

    A.forEachIndexed { index, value ->
        countMap[value] = countMap.getOrPut(value) { 0 } + 1
        indexMap.putIfAbsent(value, index)
    }

    return countMap
        .filter { it.value == 1 }
        .minByOrNull { indexMap[it.key] ?: 100_000 }
        ?.key ?: -1
}
