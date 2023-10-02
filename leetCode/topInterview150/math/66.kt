package leetCode.topInterview150.math

class Solution66 {
    fun plusOne(digits: IntArray): IntArray {
        if (digits.all { it == 9 })
            return intArrayOf(1) + IntArray(digits.size)

        digits[digits.lastIndex] += 1
        for (i in digits.indices.reversed()) {
            if (digits[i] == 10) {
                digits[i] = 0
                digits[i - 1] += 1
            }
            else return digits
        }

        return digits
    }
}