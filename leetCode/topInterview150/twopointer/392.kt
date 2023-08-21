package leetCode.topInterview150.twopointer

class Solution392 {
    fun isSubsequence(s: String, t: String): Boolean {
        if (s.isEmpty()) return true

        var sIdx = 0
        t.forEach { tValue ->
            if (tValue == s[sIdx]) sIdx++
            if (sIdx >= s.length) return true
        }

        return false
    }
}