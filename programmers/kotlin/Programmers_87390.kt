package programmers.kotlin

import kotlin.math.max

class Programmers87390 {
    fun solution(n: Int, left: Long, right: Long): ArrayList<Long> {
        val flattenArray = arrayListOf<Long>()
        for (i in left .. right) {
            flattenArray.add(max(i / n.toLong() + 1L, i % n.toLong() + 1L))
        }

        return flattenArray
    }

}