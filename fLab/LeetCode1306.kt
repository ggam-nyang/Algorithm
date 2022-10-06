package fLab

class LeetCode1306 {
    fun maxFreq(s: String, maxLetters: Int, minSize: Int, maxSize: Int): Int {
        val subStrMap = hashMapOf<String, Int>()
        for (len in minSize .. maxSize) {
            getSubstrings(s, len, maxLetters)
                .forEach { subStr ->
                    subStrMap[subStr] = subStrMap.getOrPut(subStr) { 0 } + 1
                }
        }

        return subStrMap.maxBy { it.value }?.value ?: 0
    }

    fun getSubstrings(s: String, size: Int, maxLetters: Int): ArrayList<String> {
        val subStrList = arrayListOf<String>()
        for (i in 0 .. s.length - size) {
            val subString = s.substring(i, i + size)
            if (hasValidLetters(subString, maxLetters)) subStrList.add(subString)
        }

        return subStrList
    }

    fun hasValidLetters(subString: String, maxLetters: Int) : Boolean {
        return subString.toSet().size <= maxLetters
    }
}
