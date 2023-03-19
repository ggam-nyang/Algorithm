package baekjoon

import java.util.*

private val dx = intArrayOf(0, 0, -1, 1)
private val dy = intArrayOf(-1, 1, 0, 0)
private var R = 0
private var C = 0
private var K = 0
private var answer = 0
private lateinit var graph: Array<IntArray>
private lateinit var visited: Array<BooleanArray>

fun main() = with(Scanner(System.`in`)) {
    val (r, c, k) = nextLine().split(" ").map(String::toInt)
    R = r
    C = c
    K = k
    val tempGraph = arrayListOf<CharArray>()
    repeat(r) {
        tempGraph.add(nextLine().toCharArray())
    }
    graph = tempGraph.map { ca ->
        ca.map {
            if (it == '.') 0
            else 1
        }
            .toIntArray()
    }.toTypedArray()

    graph[R - 1][0] = 1
    dfs(R - 1, 0, 1)

    println(answer)
}

private fun dfs(x: Int, y: Int, cnt: Int) {
    if (cnt == K && x == 0 && y == C - 1) answer++
    else if (cnt == K) return
    else {
        (0..3).forEach { i ->
            val nx = x + dx[i]
            val ny = y + dy[i]

            if (nx in 0 until R && ny in 0 until C && graph[nx][ny] == 0) {
                graph[nx][ny] = 1
                dfs(nx, ny, cnt + 1)
                graph[nx][ny] = 0
            }
        }
    }
}