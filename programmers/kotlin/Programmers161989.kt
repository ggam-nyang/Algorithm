package programmers.kotlin

import java.util.PriorityQueue

class Programmers161989 {
    fun solution(n: Int, m: Int, section: IntArray): Int {
        var answer: Int = 0

        val pq = PriorityQueue<Int>()
        pq.addAll(section.toList())

        var now = 1

        while (now <= section.last() && pq.isNotEmpty()) {
            answer++
            now = pq.poll() + m
            while (pq.isNotEmpty()) {
                if (pq.peek() < now) pq.poll()
                else break
            }
        }

        return answer
    }
}