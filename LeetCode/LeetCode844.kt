package LeetCode

class LeetCode844 {
    fun backspaceCompare(s: String, t: String): Boolean {
        val newS = deleteHash(0, s, "")
        val newT = deleteHash(0, t, "")

        println("$newS,  $newT")

        return newS == newT
    }

    private fun deleteHash(hashCnt: Int, str: String, alpha: String): String {
        if (str == "") return alpha
        if (hashCnt >= str.length)
            return alpha

        return if (str.last() != '#') {
            if (hashCnt == 0)
                deleteHash(hashCnt , str.dropLast(1), str.last() + alpha)
            else deleteHash(hashCnt - 1, str.dropLast(1), alpha)
        }
        else deleteHash(hashCnt + 1, str.dropLast(1), alpha)
    }
}
