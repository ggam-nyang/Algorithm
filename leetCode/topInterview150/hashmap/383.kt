package leetCode.topInterview150.hashmap

class Solution {
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val magazineCharMap =
            magazine
                .asSequence()
                .groupBy { it }
                .mapValues { it.value.size }.toMutableMap()

        ransomNote.forEach { note ->
            if (magazineCharMap.contains(note) && magazineCharMap[note]!! > 0) {
                magazineCharMap[note] = magazineCharMap[note]!! - 1
            } else {
                return false
            }
        }

        return true
    }
}