package baekjoon

import java.lang.Integer.min
import java.util.*

private lateinit var graph: Array<ArrayList<Vd>>
private var N = 0
private var Q = 0
private var answer = 0
private lateinit var visited: BooleanArray
const val MAX = 1_000_000_001


fun main() = with(Scanner(System.`in`)) {
    val (n, q) = nextLine().split(" ").map(String::toInt)
    N = n
    Q = q

    graph = Array(n + 1) { arrayListOf() }

    repeat((1 until n).count()) {
        val (p, q, r) = nextLine().split(" ").map(String::toInt)

        graph[p].add(Vd(q, r))
        graph[q].add(Vd(p, r))
    }


    repeat((1 .. q).count()) {
        val (k, v) = nextLine().split(" ").map(String::toInt)
        answer = 0
        visited = BooleanArray(N + 1)

        dfss(k, v, MAX)

        println(answer)
    }
}

private fun dfss(k: Int, v: Int, minUsado: Int) {
    visited[v] = true

    graph[v].forEach { vd ->
        if (!visited[vd.video]) {
            visited[vd.video] = true
            if (min(minUsado, vd.usado) >= k) {
                answer++
            }
            dfss(k, vd.video, min(vd.usado, minUsado))
            visited[vd.video] = false
        }
    }
}

data class Vd(
    val video: Int,
    val usado: Int,
)
