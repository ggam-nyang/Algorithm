package leetCode.topInterview150.array

class Solution13 {
    fun romanToInt(s: String): Int {
        return s.mapIndexed { index, c ->
            c.roman() * if ((s.getOrNull(index + 1)?.roman() ?: 0) > c.roman()) -1 else 1
        }.sum()
    }

    fun Char.roman(): Int {
        return when(this) {
            'I' -> 1
            'V' -> 5
            'X' -> 10
            'L' -> 50
            'C' -> 100
            'D' -> 500
            'M' -> 1000
            else -> 0
        }
    }
}