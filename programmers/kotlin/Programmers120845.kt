package programmers.kotlin

class Programmers120845 {
    fun solution(box: IntArray, n: Int): Int {
        return box.map { it / n }
            .reduce { acc, i -> acc * i }
    }
}
