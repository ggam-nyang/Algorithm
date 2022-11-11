package LeetCode

import kotlin.math.min

class LeetCode153 {
    fun findMin(nums: IntArray): Int {
        var left = 0
        var right = nums.size - 1

        var mid = 0

        while (left <= right) {
            mid = (left + right) / 2
            val midVal = nums[mid]
            if (mid == 0) return if (nums.size == 1)  midVal else min(midVal, nums[mid + 1])
            if (mid == nums.size - 1) return nums.last()

            if (nums[mid + 1] > midVal && midVal < nums[mid - 1]) return midVal

            if (midVal >= nums[left] && midVal >= nums[right]) left = mid + 1
            else if (midVal <= nums[right] && midVal <= nums[left]) right = mid - 1
            else right = mid - 1
        }

        return nums[left]
    }
}