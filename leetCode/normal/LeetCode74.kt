package leetCode.normal

class LeetCode74 {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        var left = 0
        var right = matrix.size - 1

        var mid = 0

        while (left <= right) {
            mid = (left + right) / 2
            val midVal = matrix[mid]

            if (midVal.first() <= target && target <= midVal.last())
                return binarySearch(midVal, target)
            else if (target < midVal.first()) right = mid - 1
            else left = mid + 1
        }

        return false
    }

    private fun binarySearch(midVal: IntArray, target: Int): Boolean {
        var left = 0
        var right = midVal.size - 1

        while (left <= right) {
            val mid = (left + right) / 2

            if (midVal[mid] < target) left = mid + 1
            else if (midVal[mid] > target) right = mid - 1
            else return true
        }

        return false
    }

    // solve 2. flatMap -> binarySearch
    fun searchMatrix1(matrix: Array<IntArray>, target: Int): Boolean {
        val test = matrix.flatMap { it.toList() }

        return binarySearch(test.toIntArray(), target)
    }
}
