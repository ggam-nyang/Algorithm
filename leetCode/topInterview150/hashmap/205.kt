package leetCode.topInterview150.hashmap

class Solution205 {
    fun isIsomorphic(s: String, t: String): Boolean {
        val ans = s.zip(t).toSet().size

        return ans == s.toSet().size && ans == t.toSet().size
    }
}