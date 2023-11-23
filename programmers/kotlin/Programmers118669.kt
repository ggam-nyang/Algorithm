package programmers.kotlin

import kotlin.math.max
import kotlin.math.min

const val MAX_TIME = 100000000

// 118669

fun main() {
    Programmers118669().solution(6,
        paths = arrayOf(intArrayOf(1, 2, 3), intArrayOf(2, 3, 5), intArrayOf(2, 4, 2), intArrayOf(2, 5, 4), intArrayOf(3, 4, 4), intArrayOf(4, 5, 3), intArrayOf(4, 6, 1), intArrayOf(5, 6, 1)),
        gates = intArrayOf(1, 3),
        summits = intArrayOf(5),
    )
}

class Programmers118669 {
    private var places: MutableList<Place> = mutableListOf()
    private var pathMap: Array<MutableList<Pair<Int, Int>>> = Array(0) { mutableListOf() }

    fun solution(n: Int, paths: Array<IntArray>, gates: IntArray, summits: IntArray): IntArray {
        places = (0 .. n).map { Place.REST }.toMutableList()
        gates.forEach { places[it] = Place.GATE }
        summits.forEach { places[it] = Place.SUMMIT }

        pathMap = Array(n + 1) { mutableListOf() }

        paths.forEach { path ->
            val (to, from, time) = path
            pathMap[to].add(Pair(from, time))
            pathMap[from].add(Pair(to, time))
        }

        var answer = Pair(0, MAX_TIME)
        gates.forEach { gate ->
            val (summitNum, maxIntensity) = bfs(gate, n)
            println("summit: $summitNum,  max: $maxIntensity")
            if (maxIntensity < answer.second)
                answer = Pair(summitNum, maxIntensity)
            else if (maxIntensity == answer.second)
                answer = Pair(min(summitNum, answer.first), maxIntensity)
        }

        return answer.toList().toIntArray()
    }

    fun bfs(startGate: Int, n: Int): Pair<Int, Int> {
        val visited: Array<Array<Boolean>> = Array(n + 1) { Array(n + 1) { false } }
        val queue = ArrayDeque<PathMeta>()
        val start = PathMeta(startGate = startGate, now = startGate)
        queue.addLast(start)

        var answer = Pair(0, MAX_TIME)
        loop@ while (queue.isNotEmpty()) {
            val pm = queue.removeFirst()
            if (pm.maxIntensity > answer.second) continue@loop
            println(pm)
            pathMap[pm.now].forEach { destinationMeta ->
                val (to, time) = destinationMeta
                if (visited[pm.now][to]) return@forEach

                if (places[to] == Place.SUMMIT) {
                    if (pm.isSummitClear) return@forEach
                    visited[pm.now][to] = true
                    pm.updateMeta(true, to, max(pm.maxIntensity, time), to)
                    queue.addLast(pm)
                }

                if (places[to] == Place.GATE) {
                    if (pm.startGate != to) return@forEach
                    if (!pm.isSummitClear) return@forEach
                    println("$pm,  $to")
                    if (pm.maxIntensity < answer.second)
                        answer = Pair(pm.summitNum, pm.maxIntensity)
                    else if (pm.maxIntensity == answer.second)
                        answer = Pair(min(pm.summitNum, answer.first), pm.maxIntensity)
                }

                if (places[to] == Place.REST) {
                    visited[pm.now][to] = true
                    pm.updateMeta(maxIntensity = max(pm.maxIntensity, time), now = to)
                    queue.addLast(pm)
                }
            }
        }

        return answer
    }
}

data class PathMeta(
    var isSummitClear: Boolean = false,
    var summitNum: Int = -1,
    var maxIntensity: Int = 0,
    val startGate: Int,
    var now: Int
) {
    fun updateMeta(
        isSummitClear: Boolean = this.isSummitClear,
        summitNum: Int = this.summitNum,
        maxIntensity: Int = this.maxIntensity,
        now: Int = this.now
    ) {
        this.isSummitClear = isSummitClear
        this.summitNum = summitNum
        this.maxIntensity = maxIntensity
        this.now = now
    }
}

enum class Place {
    GATE,
    SUMMIT,
    REST
}