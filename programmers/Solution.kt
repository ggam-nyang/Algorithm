package programmers

import java.util.PriorityQueue

class Solution {
    fun solution(n: Int, m: Int, section: IntArray): Int {
        var answer: Int = 0

        val pq = PriorityQueue<Int>()
        pq.addAll(section.toList())

        var now = 1

        while (now < section.last()) {
            answer++
            now = pq.poll() + m - 1
            while (pq.isNotEmpty()) {
                if (pq.peek() <= now) pq.poll()
                else break
            }
        }

        return answer
    }
}