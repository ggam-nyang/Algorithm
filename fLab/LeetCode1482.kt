package fLab

class LeetCode1482 {
    fun minDays(bloomDay: IntArray, m: Int, k: Int): Int {
        if (bloomDay.size < m * k) {
            return -1
        }

        var left = 1
        var right = bloomDay.max()!!

        var mid = -1
        while (left <= right) {
            mid = (left + right) / 2

            if (checkFlowers(mid, bloomDay, m, k)) right = mid - 1
            else left = mid + 1
        }

        return if (checkFlowers(left, bloomDay, m, k)) left else -1
    }

    private fun checkFlowers(day: Int, bloomDays: IntArray, m: Int, k: Int) : Boolean {
        var cnt = 0
        var continueDay = 0
        bloomDays.forEach { bloomDay ->
            if (bloomDay <= day) continueDay++
            else continueDay = 0

            if (continueDay == k) {
                cnt++
                continueDay = 0
            }
        }

        return cnt >= m
    }
}