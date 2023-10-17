package leetCode.topInterview150.hashmap

class Solution49 {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map = hashMapOf<String, MutableList<String>>()
        strs.forEach { str ->
            val sortedString = str.alphabetized()
            map.putIfAbsent(sortedString, mutableListOf())
            map[sortedString]!!.add(str)
        }

        return map.map { it.value }
    }

    private fun String.alphabetized() = String(toCharArray().apply { sort() })
}