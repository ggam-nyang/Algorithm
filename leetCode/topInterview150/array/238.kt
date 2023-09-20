package leetCode.topInterview150.array

class Solution238 {
    fun productExceptSelf(nums: IntArray): IntArray {
        val answer = IntArray(nums.size) { 1 }
        var n = 1

        nums.indices.forEach {
            answer[it] = n
            n *= nums[it]
        }
        n = 1
        nums.indices.reversed().forEach {
            answer[it] *= n
            n *= nums[it]
        }
        return answer
    }
}