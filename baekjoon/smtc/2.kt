package baekjoon.smtc

import java.util.*
import kotlin.collections.ArrayDeque

private val dx = intArrayOf(-1, 1, 0, 0)
private val dy = intArrayOf(0, 0, -1, 1)
private lateinit var graph: ArrayList<IntArray>
private lateinit var checked: Array<BooleanArray>
private var area = 0

fun main() = with(Scanner(System.`in`)) {
    val (N, M) = nextLine().split(' ').map(String::toInt)

    graph = arrayListOf()
    (1..N).forEach { _ ->
        graph.add(nextLine().split(' ').map(String::toInt).toIntArray())
    }
    checked = Array(N) { BooleanArray(M) }

    (0 until N).forEach { x ->
        (0 until M).forEach { y ->
            if (graph[x][y] == 0 && !checked[x][y]) {
                bfs(x, y, N, M)
                area++
            }
        }
    }

    println(area)
}

private fun dfs(startX: Int, startY: Int, N: Int, M: Int) {
    (0..3).forEach { i ->
        var newX = startX + dx[i]
        var newY = startY + dy[i]

        if (newX < 0) newX += N
        if (newX >= N) newX -= N

        if (newY < 0) newY += M
        if (newY >= M) newY -= M

        if (!checked[newX][newY] && graph[newX][newY] == 0) {
            checked[newX][newY] = true
            dfs(newX, newY, N, M)
        }
    }
}

fun bfs(startX: Int, startY: Int, N: Int, M: Int) {
    val queue = ArrayDeque<Pt>()
    queue.add(Pt(startX, startY))

    while (queue.isNotEmpty()) {
        val (nowX, nowY) = queue.removeFirst()

        (0..3).forEach { i ->
            var newX = nowX + dx[i]
            var newY = nowY + dy[i]

            if (newX < 0) newX += N
            if (newX >= N) newX -= N

            if (newY < 0) newY += M
            if (newY >= M) newY -= M

            if (!checked[newX][newY] && graph[newX][newY] == 0) {
                checked[newX][newY] = true
                queue.add(Pt(newX, newY))
            }
        }
    }
}

data class Pt(
    val x: Int,
    val y: Int
)
