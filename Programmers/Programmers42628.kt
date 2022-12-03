package Programmers

import java.util.PriorityQueue

class Programmers42628 {
    fun solution(operations: Array<String>): IntArray {
        val priorityQueue = PriorityQueue<Int>(operations.size / 2)

        operations.forEach { op ->
            val (order, value) = op.split(" ")
            if (order == "I") priorityQueue.add(value.toInt())
            else if (value == "1") {
                priorityQueue.remove(priorityQueue.maxOrNull() ?: -1)
            }
            else priorityQueue.poll()
        }

        if (priorityQueue.isEmpty()) return intArrayOf(0, 0)

        return intArrayOf(priorityQueue.last(), priorityQueue.first())
    }
}
