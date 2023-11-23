package programmers.kotlin

class Programmers154538 {
    fun solution(x: Int, y: Int, n: Int): Int {
        val q = ArrayDeque<Pair<Int, Int>>()
        q.add(Pair(x, 0))
        val checked = BooleanArray(1_000_001)

        while (q.isNotEmpty()) {
            val (curr, cnt) = q.removeFirst()

            if (curr == y) return cnt

            if (curr + n <= y && !checked[curr + n]) {
                q.add(Pair(curr + n, cnt + 1))
                checked[curr + n] = true
            }

            if (curr * 2 <= y && !checked[curr * 2]) {
                q.add(Pair(curr * 2, cnt + 1))
                checked[curr * 2] = true
            }

            if (curr * 3 <= y && !checked[curr * 3]) {
                q.add(Pair(curr * 3, cnt + 1))
                checked[curr * 3] = true
            }
        }

        return -1
    }
}