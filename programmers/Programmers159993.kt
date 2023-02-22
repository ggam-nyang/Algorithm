package programmers

import java.lang.Exception

class Programmers159993 {
    private lateinit var graph: Array<String>
    private val dx = intArrayOf(0, 0, -1, 1)
    private val dy = intArrayOf(-1, 1, 0, 0)

    fun solution(maps: Array<String>): Int {
        graph = maps

        val (startX, startY) = findStart()
        val leverInfo = findLever(startX, startY, 0, Array(graph.size) {BooleanArray(graph[0].length)})

        if (!leverInfo.isLever) return -1

        return findEnd(leverInfo.lx, leverInfo.ly, leverInfo.count, Array(graph.size) {BooleanArray(graph[0].length)})
    }

    private fun findEnd(x: Int, y: Int, cnt: Int, visited: Array<BooleanArray>): Int {
        var answer: Int
        (0..3).forEach {d ->
            val nx = x + dx[d]
            val ny = y + dy[d]

            if (nx in graph.indices && ny in 0 until graph[0].length && !visited[nx][ny]) {
                val dest = graph[nx][ny]
                visited[nx][ny] = true
                if (dest == 'E') return cnt + 1
                if (dest == 'O' || dest == 'S') {
                    answer = findEnd(nx, ny, cnt + 1, visited)
                    if (answer != -1) return answer
                }
                visited[nx][ny] = false
            }
        }

        return -1
    }

    private fun findStart(): Pair<Int, Int> {
        graph.forEachIndexed { rIdx, row ->
            row.forEachIndexed { cIdx, col ->
                if (col == 'S') return Pair(rIdx, cIdx)
            }
        }

        throw Exception()
    }

    private fun findLever(x: Int, y: Int, cnt: Int, visited: Array<BooleanArray>): DestInfo {
        var answer: DestInfo
        (0..3).forEach {d ->
            val nx = x + dx[d]
            val ny = y + dy[d]

            if (nx in graph.indices && ny in 0 until graph[0].length && !visited[nx][ny]) {
                val dest = graph[nx][ny]
                visited[nx][ny] = true
                if (dest == 'L') return DestInfo(true, nx, ny, cnt + 1)
                if (dest == 'O' || dest == 'E') {
                    answer = findLever(nx, ny, cnt + 1, visited)
                    if (answer.isLever) return answer
                }
                visited[nx][ny] = false
            }
        }

        return DestInfo(false, 0, 0, 0)
    }

    data class DestInfo(
        val isLever: Boolean,
        val lx: Int,
        val ly: Int,
        val count: Int
    )
}