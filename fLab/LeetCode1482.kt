package fLab

import java.util.PriorityQueue

class Solution {
    fun minDays(bloomDay: IntArray, m: Int, k: Int): Int {
        if (bloomDay.size < m * k) {
            return -1
        }

        val bloomHeap = PriorityQueue<Int>(bloomDay.toSet())

        var day = 0
        while (bloomHeap.isNotEmpty()) {
            day = bloomHeap.poll()

            if (checkFlowers(day, bloomDay, m, k)) return day
        }

        return -1
    }

    private fun checkFlowers(day: Int, bloomDay: IntArray, m: Int, k: Int) : Boolean {
        var cnt = 0
        var i = 0
        loop@ while (i < bloomDay.size) {
            if (bloomDay[i] > day) {
                i++
                continue
            }
            for (j in 0 until k) {
                if (bloomDay[i + j] > day) {
                    i += j + 1
                    break@loop
                }
            }
            cnt++
            if (cnt >= m) return true

            i += k
        }

        return cnt >= m
    }
}