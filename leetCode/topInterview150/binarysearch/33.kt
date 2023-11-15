package leetCode.topInterview150.binarysearch

class Solution33 {
    fun search(nums: IntArray, target: Int): Int {
        if (nums.size == 1) return if (target == nums.first()) 0 else -1
        var left = 0
        var right = nums.lastIndex

        // change to binarySearch
        var k = 0
        for (i in 0 until  nums.lastIndex) {
            if (nums[i] > nums[i + 1]) k = i
        }

        val leftAnswer = binarySearch(left, k, nums, target)
        val rightAnswer = binarySearch(k + 1, right, nums, target)

        return if (leftAnswer != -1) leftAnswer else rightAnswer
    }

    private fun binarySearch(start: Int, end: Int, nums: IntArray, target: Int): Int {
        var left = start
        var right = end
        while (left <= right) {
            val mid = (left + right) / 2

            if (nums[mid] > target) {
                right = mid - 1
            } else if (nums[mid] < target) {
                left = mid + 1
            } else {
                return mid
            }
        }

        return -1
    }
}