package leetCode.topInterview150.array

class Solution9 {
    fun isPalindrome(x: Int): Boolean {
        if (x == 0) return true
        if (x < 0) return false

        val stringX = x.toString()

        for (i in 0 until stringX.length / 2) {
            if (stringX[i] != stringX[stringX.length - 1 - i]) return false
        }

        return true
    }
}