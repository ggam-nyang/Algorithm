package leetCode.topInterview150.binarysearch

class Solution162 {
    fun findPeakElement(nums: IntArray): Int {
        var left = 0
        var right = nums.lastIndex

        while (left < right) {
            val mid = (left + right) / 2

            if (nums[mid] > nums[mid + 1]) right = mid
            else left = mid + 1
        }

        return left
    }
}