package baekjoon

import java.util.Scanner

private lateinit var graph: Array<ArrayList<Int>>
private lateinit var checked: Array<Boolean>
private var virus = 0

fun main() = with(Scanner(System.`in`)) {
    val computerN = nextLine().toInt()
    val edgeN = nextLine().toInt()

    checked = Array(computerN + 1) { false }
    graph = Array( computerN + 1 ) { arrayListOf<Int>() }
    (1..edgeN).forEach { _ ->
        val (to, from) = nextLine().split(" ").map(String::toInt)
        graph[to].add(from)
        graph[from].add(to)
    }

    checked[1] = true
    dfs(1)
    println(virus - 1)
}

private fun dfs(n: Int) {
    virus++

    graph[n].forEach { node ->
        if (!checked[node]) {
            checked[node] = true
            dfs(node)
        }
    }
}