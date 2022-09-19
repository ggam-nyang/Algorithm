import kotlin.math.abs
import kotlin.math.sqrt

class Programmers12917 {
    fun solution(s: String): String {
        return s.toCharArray().sortedDescending().joinToString("")
    }
}