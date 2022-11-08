class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1

        while (left <= right) {
            val mid = (left + right) / 2
            val midVal = nums[mid]
            if (midVal == target) return mid

            if (midVal >= nums[left]) {
                if (target < midVal && target >= nums[left]) right = mid - 1
                else left = mid + 1
            }
            else {
                if (target > midVal && target <= nums[right]) left = mid + 1
                else right = mid - 1
            }
        }

        return -1
    }
}