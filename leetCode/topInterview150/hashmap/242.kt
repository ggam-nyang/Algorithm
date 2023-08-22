package leetCode.topInterview150.hashmap

class Solution242 {
    fun isAnagram(s: String, t: String): Boolean {
        val sMap = s.asSequence()
            .groupBy { it }
            .mapValues { it.value.size }
            .toMutableMap()

        t.forEach { char ->
            if (!sMap.contains(char)) return false
            if (sMap[char]!! <= 0) return false
            sMap[char] = sMap[char]!! - 1
        }

        if (sMap.values.all { it == 0 }) return true
        return false
    }
}