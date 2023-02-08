package baekjoon

import java.util.*
import kotlin.collections.ArrayDeque


fun main() = with(Scanner(System.`in`)) {
    val N = nextLine().toInt()
    val needs = nextLine().split(" ").map(String::toInt)

    val answer = IntArray(N)
    val queue = ArrayDeque<Pizza>()

    queue.addAll(needs.mapIndexed{ index, i -> Pizza(index, i) })

    var now = 1
    while (queue.isNotEmpty()) {
        val curr = queue.removeFirst()
        if (curr.remain == 1) answer[curr.index] = now
        else {
            curr.remain--
            queue.addLast(curr)
        }
        now++
    }

    answer.forEach {
        print("$it ")
    }
}

data class Pizza(
    val index: Int,
    var remain: Int
)