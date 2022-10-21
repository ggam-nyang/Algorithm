package fLab

class Solution {
    fun findDiagonalOrder(nums: List<List<Int>>): IntArray {
        val newNums = nums.mapIndexed { i, v ->
            v.mapIndexed { j, vv ->  Triple(i + j, j, vv) }
        }.flatten()

        return newNums.sortedWith(compareBy<Triple<Int, Int, Int>> { it.first }
            .thenBy { it.second }
        )
            .map { it.third }
            .toIntArray()
    }
}