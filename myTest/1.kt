package myTest

class Solution1 {
    fun solution(s: String, N: Int): Int {
        val fanDigitals = mutableListOf<Int>()
        val nRange = 1..N

        for (i in 0 .. s.length - N) {
            val temp = s.substring(i, i + N)
            if (isFanDigital(temp, nRange)) fanDigitals.add(temp.toInt())
        }

        return fanDigitals.maxOrNull() ?: -1
    }

    private fun isFanDigital(temp: String, nRange: IntRange) =
        temp.map { it.digitToInt() }.containsAll(nRange.toList())
}