package leetCode.topInterview150.twopointer

class Solution167 {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var left = 0
        var right = numbers.lastIndex

        while (left <= right) {
            when {
                numbers[left] + numbers[right] == target -> return intArrayOf(left + 1, right + 1)
                numbers[left] + numbers[right] < target -> left++
                else -> right--
            }
        }

        return intArrayOf(0, 0)
    }
}