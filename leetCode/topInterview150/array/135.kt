package leetCode.topInterview150.array

import kotlin.math.max

class Solution135 {
    fun candy(ratings: IntArray): Int {
        val candySize = ratings.size
        val forwardArray = IntArray(candySize) { 1 }
        val backwardArray = IntArray(candySize) { 1 }

        for (i in 1 until candySize) {
            if (ratings[i] > ratings[i - 1]) forwardArray[i] = forwardArray[i - 1] + 1
        }

        for (i in candySize - 2 downTo 0) {
            if (ratings[i] > ratings[i + 1]) backwardArray[i] = backwardArray[i + 1] + 1
        }

        return ratings.mapIndexed { index, _ -> max(forwardArray[index], backwardArray[index])}.sum()
    }
}