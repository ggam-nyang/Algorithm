package codlity

// you can also use imports, for example:
// import kotlin.math.*

// you can write to stdout for debugging purposes, e.g.
// println("this is a debug message")

private fun solution(N: Int, A: IntArray): IntArray {
    val tempMap = hashMapOf<Int, Int>()
    var maxValue = 0

    A.forEach { operation ->
        if (operation <= N) {
            tempMap[operation] = tempMap.getOrPut(operation) { 0 } + 1
        }
        if (operation > N) {
            maxValue += tempMap.values.maxOrNull() ?: 0
            tempMap.clear()
        }
    }
    val answer = IntArray(N) { maxValue }
    tempMap.forEach { (idx, count) -> answer[idx - 1] += count }

    return answer
}
