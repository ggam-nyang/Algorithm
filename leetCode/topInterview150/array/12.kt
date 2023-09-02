package leetCode.topInterview150.array

class Solution12 {
    private val romanList =
        arrayListOf(1000 to 'M', 500 to 'D', 100 to 'C', 50 to 'L', 10 to 'X', 5 to 'V', 1 to 'I')

    fun intToRoman(num: Int): String {
        romanList.forEachIndexed { idx, p ->
            if (num / p.first < 1) return@forEachIndexed

            val divide = num / p.first
            if (divide == 9) return
        }
    }
}