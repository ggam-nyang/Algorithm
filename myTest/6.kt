package myTest

import java.lang.Integer.max

class Solution6 {
    fun solution(prices: IntArray, k: Int): Int {
        var answer: Int = 0
        for (i in 0 until prices.size - k) {
            val revenue =
                prices
                    .asSequence()
                    .drop(i + 1)
                    .map { it - prices[i] }
                    .sortedDescending()
                    .take(k)
                    .sum()

            answer = max(revenue, answer)
        }

        return if (answer <= 0) -1 else answer
    }
}