package leetCode.topInterview150.binarysearch

class Solution74 {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val map = matrix.flatMap { it.toList() }

        var left = 0
        var right = map.lastIndex

        while (left <= right) {
            val mid = (left + right) / 2

            when {
                map[mid] < target -> left = mid + 1
                map[mid] > target -> right = mid - 1
                else -> return true
            }
        }

        return false
    }

    fun searchMatrix1(matrix: Array<IntArray>, target: Int): Boolean {
        val col = matrix.size
        val row = matrix.first().size
        var left = 0
        var right = col * row - 1

        while (left <= right) {
            val mid = (left + right) / 2
            val midValue = matrix[mid / row][mid % row]

            when {
                midValue < target -> left = mid + 1
                midValue > target -> right = mid - 1
                else -> return true
            }
        }

        return false
    }
}
