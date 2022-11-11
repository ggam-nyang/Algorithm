package LeetCode

class Solution {
    fun findPeakElement(nums: IntArray): Int {
        if (nums.size == 1) return 0
        if (isPeak(nums.first(), null, nums[1])) return 0

        for (i in 1 until nums.size - 1) {
            if (isPeak(nums[i], nums[i - 1], nums[i + 1])) return i
        }

        if (isPeak(nums.last(), nums[nums.size - 2], null)) return nums.size - 1

        return -1
    }

    private fun isPeak(target: Int, prev: Int?, next: Int?): Boolean {
        return (prev ?: Int.MIN_VALUE) < target && target > (next ?: Int.MIN_VALUE)
    }
}