class Solution {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        return intArrayOf(
            binarySearch(nums, target, true),
            binarySearch(nums, target, false)
            )
    }

    private fun binarySearch(nums: IntArray, target: Int, isStart: Boolean): Int {
        if (nums.isEmpty()) return -1
        if (nums.first() > target || nums.last() < target) return  - 1
        if (!nums.contains(target)) return -1

        var left = 0
        var right = nums.size - 1

        while (left <= right) {
            val mid = (left + right) / 2

            if (nums[mid] > target) right = mid - 1
            else if (nums[mid] < target) left = mid + 1
            else {
                if (isStart) right = mid - 1
                else left = mid + 1
            }
        }

        return if (isStart) left else left - 1
    }
}