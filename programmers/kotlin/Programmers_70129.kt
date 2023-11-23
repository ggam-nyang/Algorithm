package programmers.kotlin

class Solution70129 {
    fun solution(s: String): IntArray {
        var deleteCnt = 0
        var convertCnt = 0
        var currentStr = s

        while (currentStr.length != 1) {
            val convertResult = convert(currentStr)
            convertCnt ++
            deleteCnt += convertResult.first
            currentStr = convertResult.second
        }

        var answer: IntArray = intArrayOf(convertCnt, deleteCnt)
        return answer
    }

    private fun convert(s: String): Pair<Int, String> {
        var deleteCnt = 0
        s.forEach {
            if (it == '0') deleteCnt ++
        }

        val convertStr = s.filter { it == '1' }.length.toString(2)

        return Pair(deleteCnt, convertStr)
    }
}