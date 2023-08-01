package baekjoon.tony.data_structure2

import java.util.PriorityQueue

fun main() {
    val N = readln().toInt()
    val graph = Array(N) { IntArray(N) }

    for (i in 0 until N) {
        val row = readln().split(" ").map(String::toInt).toIntArray()
        graph[i] = row
    }

    val heap = PriorityQueue(graph.last().mapIndexed { index, value -> Point(N - 1, index, value) })
    for (i in 1 until N) {
        val point = heap.poll()
        heap.add(Point(point.row - 1, point.col, graph[point.row - 1][point.col]))
    }
    println(heap.peek().value)
}

data class Point(
    val row: Int,
    val col: Int,
    val value: Int
) : Comparable<Point> {
    override fun compareTo(other: Point): Int {
        return other.value - this.value
    }
}