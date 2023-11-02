package leetCode.topInterview150.array

import kotlin.math.max

class Solution42 {
    fun trap(height: IntArray): Int {
        val (maxIdx, maxHeight) = height.withIndex().maxBy { it.value }

        val leftTrapSum = calculateTrap(height, 0, maxIdx)
        val rightTrapSum = calculateTrap(height, height.lastIndex, maxIdx)

        return leftTrapSum + rightTrapSum
    }

    private fun calculateTrap(height: IntArray, startIdx: Int, endIdx: Int): Int {
        var maxHeight = 0
        var trapWater = 0

        for (i in
            if (startIdx < endIdx) startIdx .. endIdx
            else startIdx downTo endIdx
        ) {
            maxHeight = max(maxHeight, height[i])
            trapWater += maxHeight - height[i]
        }

        return trapWater
    }
}