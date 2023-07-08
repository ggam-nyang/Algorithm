package programmers

class Programmers181188 {
    fun solution(targets: Array<IntArray>): Int {
        var answer: Int = 0
        val sortedTargets = targets.sortedWith(compareBy<IntArray> { it[1] }.thenBy{ it[0] })

        var e = 0
        sortedTargets.forEach { target ->
            if (target[0] >= e) {
                answer++
                e = target[1]
            }
        }

        return answer
    }
}