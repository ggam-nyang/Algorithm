package leetCode.topInterview150.array

class Solution26 {
    fun removeDuplicates(nums: IntArray): Int {
        val numSet = hashSetOf<Int>()
        var left = 0
        var right = 0

        while (right < nums.size) {
            val target = nums[right]
            if (numSet.contains(target)) right++
            else {
                numSet.add(target)
                nums[left++] = target
            }
        }

        return numSet.size
    }
}