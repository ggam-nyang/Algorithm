package leetCode

import java.lang.Integer.min

class LeetCode11 {
    fun maxArea(height: IntArray): Int {
        var left = 0
        var right = height.size - 1

        var maxArea = 0

        while (left <= right) {
            val leftHeight = height[left]
            val rightHeight = height[right]
            val area = (right - left) * min(leftHeight, rightHeight)

            if (maxArea < area) maxArea = area
            if (leftHeight <= rightHeight) left++
            else right--
        }

        return maxArea
    }
}