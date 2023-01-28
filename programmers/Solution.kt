package programmers

class Solution {
    private lateinit var visited: Array<BooleanArray>
    private lateinit var newMap: Array<IntArray>
    private val dx = intArrayOf(0, 0, -1, 1)
    private val dy = intArrayOf(-1, 1, 0, 0)

    fun solution(maps: Array<String>): IntArray {
        newMap = maps.map { row ->
            row.map { char ->
                if (char == 'X') 0
                else char.digitToInt()
            }.toIntArray()
        }.toTypedArray()

        visited = Array(newMap.size) { BooleanArray(newMap[0].size) }

        val answer = arrayListOf<Int>()

        newMap.indices.forEach { r ->
            newMap[0].indices.forEach { c ->
                if (newMap[r][c] != 0 && !visited[r][c]) {
                    visited[r][c] = true
                    answer.add(bfs(r, c, newMap[r][c]))
                }
            }
        }
        if (answer.isEmpty()) answer.add(-1)

        return answer.sorted().toIntArray()
    }

    private fun bfs(x: Int, y: Int, start: Int): Int {
        var sum = start
        val q = ArrayDeque<Pt>()
        q.add(Pt(x, y))

        while (q.isNotEmpty()) {
            val (nx, ny) = q.removeFirst()
            (0 .. 3).forEach { d ->
                val newX = nx + dx[d]
                val newY = ny + dy[d]

                if (0 <= newX && newX < newMap.size && 0 <= newY && newY < newMap[0].size) {
                    if (!visited[newX][newY] && newMap[newX][newY] != 0) {
                        visited[newX][newY] = true
                        q.add(Pt(newX, newY))
                        sum += newMap[newX][newY]
                    }
                }
            }
        }

        return sum
    }

    data class Pt(
        val x: Int,
        val y: Int
    )
}