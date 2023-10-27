package leetCode.topInterview150.math

class Solution69 {
    // Binaray Search를 이용하면 더 빨라짐
    fun mySqrt(x: Int): Int {
        if (x <= 1) return x

        for (i in 1 .. x) {
            if (compareToLong(i, x)) return i - 1
        }

        return 0
    }

    private fun compareToLong(i: Int, x: Int) : Boolean {
        return i.toLong() * i > x
    }
}