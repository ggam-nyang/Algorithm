package leetCode.topInterview150.hashmap

class Solution1 {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        for (i in 0 until nums.size - 1) {
            for (j in i + 1 until nums.size) {
                if (nums[i] + nums[j] == target) return intArrayOf(i, j)
            }
        }

        return intArrayOf(0, 0)
    }

    fun twoSum1(nums: IntArray, target: Int): IntArray {
        val hashMap = hashMapOf<Int, Int>()

        for ((i, v) in nums.withIndex()) {
            val pair = hashMap[target - v]

            pair?.let {
                return intArrayOf(i, pair)
            }
            hashMap[v] = i
        }

        return intArrayOf()
    }
}