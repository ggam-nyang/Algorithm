package Programmers

class Programmers64062_retry {
    fun solution(stones: IntArray, k: Int): Int {
        var left = 0
        var right = 200000000

        var mid = 0
        var check: Boolean
        while (left <= right) {
            mid = (left + right) / 2
            check = isPossible(stones, k, mid)
            if (check) left = mid + 1
            else right = mid - 1
        }

        return left
    }

    private fun isPossible(stones: IntArray, k: Int, temp: Int) : Boolean {
        var cnt = 0
        stones.forEach { st ->
            if (st - temp <= 0) cnt++
            else cnt = 0

            if (cnt == k) return false
        }

        return true
    }
}