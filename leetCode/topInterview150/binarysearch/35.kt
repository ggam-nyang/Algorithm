package leetCode.topInterview150.binarysearch

class Solution35 {
    fun searchInsert(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.lastIndex
        var mid: Int

        while (left <= right) {
            mid = (left + right) / 2

            if (nums[mid] < target) left = mid + 1
            else if (nums[mid] > target) right = mid - 1
            else return mid
        }

        return left
    }
}