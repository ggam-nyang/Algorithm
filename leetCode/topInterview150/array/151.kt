package leetCode.topInterview150.array

class Solution151 {
    fun reverseWords(s: String): String {
        return s
            .trim()
            .replace("\\s+".toRegex(), " ")
            .split(" ")
            .reversed()
            .joinToString(" ")
    }

    fun reverseWords2(s: String): String {
        return s
            .split(" ")
            .filter { it.isNotEmpty() }
            .reversed()
            .joinToString(separator = " ")
    }
}