package leetCode.topInterview150.binarysearch

class Solution34 {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        if (nums.isEmpty()) return intArrayOf(-1, -1)

        val left = binarySearchLeft(nums, target)
        val right = binarySearchRight(nums, target)

        if (left > nums.lastIndex || right > nums.lastIndex) return intArrayOf(-1, -1)
        if (nums[left] != target || nums[right] != target) return intArrayOf(-1, -1)

        return intArrayOf(left, right)
    }

    private fun binarySearchLeft(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.lastIndex

        while (left <= right) {
            val mid = (left + right) / 2

            if (nums[mid] < target) left = mid + 1
            else right = mid - 1
        }
        return left
    }

    private fun binarySearchRight(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.lastIndex

        while (left <= right) {
            val mid = (left + right) / 2

            if (nums[mid] <= target) left = mid + 1
            else right = mid - 1
        }
        return left - 1
    }
}