package leetCode.topInterview150.hashmap

import kotlin.math.max

class Solution128 {
    fun longestConsecutive(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        val sortedSet = nums.toSortedSet()

        var cnt = 1
        var answer = 0
        var prev = sortedSet.first()
        sortedSet.forEach { curr ->
            if (curr - prev == 1) {
                cnt++
            }
            else {
                answer = max(answer, cnt)
                cnt = 1
            }
            prev = curr
        }
        answer = max(answer, cnt)

        return answer
    }
}