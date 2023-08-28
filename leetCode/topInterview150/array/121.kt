package leetCode.topInterview150.array

import kotlin.math.max

class Solution121 {
    fun maxProfit(prices: IntArray): Int {
        var minPrice = 10001
        var maxPrice = 0

        var answer = 0
        prices.forEach { price ->
            if (maxPrice < price) {
                maxPrice = price
                answer = max(answer, maxPrice - minPrice)
            }
            if (minPrice > price) {
                answer = max(answer, maxPrice - minPrice)
                maxPrice = 0
                minPrice = price
            }
        }

        return answer
    }
}