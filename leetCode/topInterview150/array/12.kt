package leetCode.topInterview150.array

class Solution12 {
    private val romanList =
        arrayListOf(1000 to 'M', 500 to 'D', 100 to 'C', 50 to 'L', 10 to 'X', 5 to 'V', 1 to 'I')

    fun intToRoman(num: Int): String {
        if (num == 0) return ""

        romanList.forEachIndexed { idx, p ->
            if (num / p.first < 1) return@forEachIndexed

            val quotient = num / p.first
            if (quotient == 4) return p.second + romanList[idx - 1].second + intToRoman(num - quotient * p.first)
            if (quotient == 1 && (p.first == 500 || p.first == 50 || p.first == 5) && num / (p.first / 5 * 9) == 1)
                return romanList[idx + 1].second + romanList[idx - 1].second + intToRoman(num - (p.first / 5 * 9))
            return p.second + intToRoman(num - p.first)
        }

        return ""
    }
}

private operator fun Char.plus(other: Char): String {
    return "$this$other"
}
