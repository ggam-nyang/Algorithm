package Programmers

class Programmers132266 {
    fun solution(n: Int, roads: Array<IntArray>, sources: IntArray, destination: Int): IntArray {
        val roadMap: Array<ArrayList<Int>> = Array(n + 1) { arrayListOf() }
        roads.map {
            roadMap[it.first()].add(it.last())
            roadMap[it.last()].add(it.first())
        }

        val distMap = Array(n + 1) { -1 }
        distMap[destination] = 0

        val visited = Array(n + 1) { 0 }
        visited[destination] = 1
        val Q = ArrayDeque<Int>()
        Q.add(destination)

        while (Q.isNotEmpty()) {
            val now = Q.removeFirst()

            roadMap[now].forEach { next ->
                if (visited[next] == 0) {
                    visited[next] = 1
                    Q.add(next)
                    distMap[next] = distMap[now] + 1
                }
            }
        }

        return sources.map { distMap[it] }.toIntArray()
    }
}