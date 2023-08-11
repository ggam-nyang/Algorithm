package leetCode.topInterview150.hashmap

class Solution290 {
    fun wordPattern(pattern: String, s: String): Boolean {
        val sList = s.split(" ")
        val leftMap = hashMapOf<Char, String>()
        val rightMap = hashMapOf<String, Char>()

        if (sList.size != pattern.length) return false

        sList.indices.forEach {
            val p = pattern[it]
            val str = sList[it]

            if (!rightMap.contains(str) && !leftMap.contains(p)) {
                leftMap[p] = str
                rightMap[str] = p
            } else if (rightMap.contains(str) && rightMap[str] != p) return false
            else if (leftMap.contains(p) && leftMap[p] != str) return false
        }

        return true
    }
}
