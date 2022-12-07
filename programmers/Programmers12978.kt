package programmers
class Programmers12978 {
    fun solution(N: Int, road: Array<IntArray>, k: Int): Int {
        val graph = Array(N + 1) { IntArray(N + 1) { 0 } }

        road.forEach { r ->
            val (from, to, time) = r

            if (graph[from][to] == 0 || graph[from][to] > time) {
                graph[from][to] = time
                graph[to][from] = time
            }
        }

//        graph.forEach {
//            it.forEach { print(it) }
//            println()
//        }

        val possibleTown = hashSetOf<Int>()
        possibleTown.add(1)

        val q = ArrayDeque<Pair<Int, Int>>()
        q.add(Pair(1, 0))

        while (q.isNotEmpty()) {
            val (town, time) = q.removeFirst()
            graph[town].forEachIndexed { index, t ->
                if (t != 0 && time + t <= k) {
                    possibleTown.add(index)
                    q.add(Pair(index, time + t))
                }
            }
        }

        return possibleTown.size
    }
}
