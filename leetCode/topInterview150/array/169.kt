package leetCode.topInterview150.array

class Solution169 {
    fun majorityElement(nums: IntArray): Int {
        return nums.groupBy { it }
            .maxBy { it.value.size }
            ?.key!!
    }
}