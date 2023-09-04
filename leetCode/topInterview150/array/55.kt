package leetCode.topInterview150.array

class Solution55 {
    fun canJump(nums: IntArray): Boolean {
        return dfs(nums, nums.lastIndex)
    }

    private fun dfsFailed(nums: IntArray, start: Int): Boolean {
        if (start == nums.lastIndex) return true
        if (start > nums.lastIndex) return false

        val maxDist = nums[start]
        (maxDist downTo 1).forEach { dist ->
            if (dfsFailed(nums, start + dist)) return true
        }

        return false
    }

    private fun dfs(nums: IntArray, currIdx: Int): Boolean {
        if (currIdx == 0) return true

        (0 until currIdx).forEach { index ->
            val dist = currIdx - index

            if (nums[index] >= dist) return dfs(nums, index)
        }

        return false
    }
}