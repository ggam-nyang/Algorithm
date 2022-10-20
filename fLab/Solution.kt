package fLab

import java.lang.Exception
import kotlin.math.max

class Solution {
    fun findDiagonalOrder(nums: List<List<Int>>): IntArray {
        val answer = arrayListOf<Int>()

        val R = nums.size
        val C = nums.map { it.size }.max() ?: 1

        for (i in 0 until max(R, C)) {
            for (j in 0 .. i) {
                try {
                    answer.add(nums[i - j][j])
                } catch (_: Exception) {

                }
            }
        }

        return answer.toIntArray()
    }
}