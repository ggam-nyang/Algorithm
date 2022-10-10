package fLab

import java.lang.Integer.min

class LeetCode1347 {
    fun minSteps(s: String, t: String): Int {
        val sMap = s.groupBy { it }.mapValues { it.value.size }
        val tMap = t.groupBy { it }.mapValues { it.value.size }

        var answer = 0
        sMap.forEach { k, v ->
            if (tMap.containsKey(k)) {
                val temp = v - tMap[k]!!
                answer += if (temp > 0) temp else 0
            } else {
                answer += v
            }
        }

        return answer
    }
}
