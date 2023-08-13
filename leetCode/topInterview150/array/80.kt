package leetCode.topInterview150.array

class Solution80 {
    fun removeDuplicates(nums: IntArray): Int {
        var (left, right) = Pair(0, 1)
        var dupCnt = 0

        while (right < nums.size) {
            if (nums[left] != nums[right]) {
                nums[++left] = nums[right]
                dupCnt = 0
            } else if (++dupCnt < 2) {
                nums[++left] = nums[right]
            }

            right++
        }

        return left + 1
    }
}