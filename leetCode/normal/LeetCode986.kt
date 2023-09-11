package leetCode.normal

import java.lang.Integer.max
import java.lang.Integer.min

class LeetCode986 {
    fun intervalIntersection(firstList: Array<IntArray>, secondList: Array<IntArray>): Array<IntArray> {
        val answer = arrayListOf<IntArray>()

        var firstIdx = 0
        var secondIdx = 0

        while (firstIdx < firstList.size && secondIdx < secondList.size) {
//            val (firstStart, firstEnd) = firstList[firstIdx]
//            val (secondStart, secondEnd) = secondList[secondIdx]

//            val low = max(firstStart, secondStart)
//            val high = min(firstEnd, secondEnd)

            val low = max(firstList[firstIdx].first(), secondList[secondIdx].first())
            val high = min(firstList[firstIdx].last(), secondList[secondIdx].last())

            if (low <= high) {
                answer.add(intArrayOf(low, high))
            }

            if (high == firstList[firstIdx].last()) firstIdx++
            else secondIdx++
        }

        return answer.toTypedArray()
    }
}