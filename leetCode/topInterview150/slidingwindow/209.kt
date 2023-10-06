package leetCode.topInterview150.slidingwindow

import kotlin.math.min

class Solution209 {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var left = 0
        var right = 0
        var sum = nums.first()
        var answer: Int? = null

        while (right < nums.size) {
            if (sum < target) {
                right++
                if (right < nums.size) sum += nums[right]
            } else {
                answer = min(answer ?: Int.MAX_VALUE, right - left + 1)
                sum -= nums[left]
                left++
            }
        }

        return answer ?: 0
    }
}