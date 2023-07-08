package myTest

import java.lang.Integer.max

class Solution {
    fun solution(schedules: IntArray): Int {
        if (schedules.size == 1) return schedules.first()
        if (schedules.size == 2) return max(schedules.first(), schedules.last())

        val robotTimes = Array(schedules.size) { 0 }
        robotTimes[0] = schedules[0]
        robotTimes[1] = schedules[1]

        for (i in 2 until robotTimes.size) {
            robotTimes[i] = max(robotTimes[i - 1], robotTimes[i - 2] + schedules[i])
        }

        return robotTimes.last()
    }
}