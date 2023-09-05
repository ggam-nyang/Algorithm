package leetCode.topInterview150.array

class Solution45 {
    fun jump(nums: IntArray): Int {
        var currIdx = nums.lastIndex
        var answer = 0

        while (currIdx != 0) {
            for (i in 0 until currIdx) {
                if (nums[i] >= currIdx - i) {
                    currIdx = i
                    answer++
                    break
                }
            }
        }

        return answer
    }
}