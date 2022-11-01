package fLab

import java.util.PriorityQueue

class Solution {
    fun minDays(bloomDay: IntArray, m: Int, k: Int): Int {
        if (bloomDay.size < m * k) {
            return -1
        }

        val bloomHeap = PriorityQueue<Int>(bloomDay.toList())

        var day = 0
        while (bloomHeap.isNotEmpty()) {
            day = bloomHeap.poll()

            if (checkFlowers(day, bloomDay, m, k)) return day
        }

        return -1
    }

    private fun checkFlowers(day: Int, bloomDay: IntArray, m: Int, k: Int) : Boolean {
        var cnt = 0
        for (i in 0 until  bloomDay.size - k) {
            if (bloomDay[i] > day) continue
            for (j in 0 until k) {
                if (bloomDay[i + k] > day) break
            }
            println("$day  $cnt  $i")
            cnt++
            if (cnt >= m) return true
        }

        return cnt >= m
    }
}