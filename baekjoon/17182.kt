package baekjoon

import java.util.*
import kotlin.math.min

private lateinit var graph: Array<IntArray>
private lateinit var visited: BooleanArray
private var n = 0
const val INF = 987654321
private var answer = INF

fun main() = with(Scanner(System.`in`)) {
    n = nextInt()
    val k = nextInt()

    graph = Array(n) { IntArray(n) }
    visited = BooleanArray(n)

    for (i in 0 until n) {
        for (j in 0 until n) {
            graph[i][j] = nextInt()
        }
    }

    for (kk in 0 until n) {
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (graph[i][j] > graph[i][kk] + graph[kk][j])
                    graph[i][j] = graph[i][kk] + graph[kk][j]
            }
        }
    }

    visited[k] = true
    dfs(k, 0, 1)
    println(answer)
}

private fun dfs(start: Int, cost: Int, level: Int) {
    if (level >= n) {
        answer = min(answer, cost)
        return
    }

    for (i in 0 until n) {
        if (!visited[i]) {
            visited[i] = true
            dfs(i, cost + graph[start][i], level + 1)
            visited[i] = false
        }
    }
}