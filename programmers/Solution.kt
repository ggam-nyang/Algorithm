package programmers

class Solution {
    fun solution(x: Int, y: Int, n: Int): Int {
        val q = ArrayDeque<Pair<Int, Int>>()
        q.add(Pair(x, 0))

        while (q.isNotEmpty()) {
            val (curr, cnt) = q.removeFirst()

            if (curr == y) return cnt

            if (curr + n <= y) q.add(Pair(curr + n, cnt + 1))
            if (curr * 2 <= y) q.add(Pair(curr * 2, cnt + 1))
            if (curr * 3 <= y) q.add(Pair(curr * 3, cnt + 1))
        }

        return -1
    }
}