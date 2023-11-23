package programmers.kotlin

class Programmers118667 {
    fun solution(queue1: IntArray, queue2: IntArray): Int {
        val q1 = ArrayDeque(queue1.toList())
        val q2 = ArrayDeque(queue2.toList())

        var sum1: Long = q1.sum().toLong()
        var sum2: Long = q2.sum().toLong()

        var cnt = 0;
        while (sum1 != sum2 && cnt < 2 * (q1.size + q2.size)) {
            cnt++
            if (sum1 > sum2) {
                val moved = q1.removeFirst()
                q2.addLast(moved)
                sum1 -= moved
                sum2 += moved
            }
            else if (sum1 < sum2) {
                val moved = q2.removeFirst()
                q1.addLast(moved)
                sum1 += moved
                sum2 -= moved
            }
        }

        return if (cnt >= 2 * (q1.size + q2.size)) -1 else cnt
    }
}