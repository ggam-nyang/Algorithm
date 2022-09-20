import kotlin.math.abs
import kotlin.math.sqrt

class Programmers12910 {
    fun solution(arr: IntArray, divisor: Int): IntArray {
        val answer = arr.filter { it % divisor == 0 }
            .sorted()
            .toIntArray()

        return if (answer.isEmpty()) intArrayOf(-1) else answer
    }
}
