package programmers

class Programmers181188 {
    val MAX = 100_000_000

    fun solution(targets: Array<IntArray>): Int {
        val sortedTargets = targets.sortedBy { it.last() }

        var end = sortedTargets.first().last()
        var count = 1

        for (target in sortedTargets) {
            if (target.first() >= end) {
                count++
                end = target.last()
            }
        }

        return count
    }
}