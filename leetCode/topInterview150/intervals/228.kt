package leetCode.topInterview150.intervals

class Solution228 {
    fun summaryRanges(nums: IntArray): List<String> {
        if (nums.isEmpty()) return emptyList()

        val answer = arrayListOf<String>()

        var start = nums.first()
        var end: Int = nums.first()
        for (i in 0 until nums.lastIndex) {
            if (nums[i] + 1 == nums[i + 1]) {
                end = nums[i + 1]
            } else {
                answer.add(makeString(start, end))
                start = nums[i + 1]
                end = nums[i + 1]
            }
        }
        answer.add(makeString(start, end))

        return answer
    }

    private fun makeString(start: Int, end: Int): String {
        if (start == end) return start.toString()
        return "$start->$end"
    }
}