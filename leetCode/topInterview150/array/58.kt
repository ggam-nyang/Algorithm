package leetCode.topInterview150.array

class Solution58 {
    fun lengthOfLastWord(s: String): Int {
        return s.trimEnd().substringAfterLast(" ").length
    }
}