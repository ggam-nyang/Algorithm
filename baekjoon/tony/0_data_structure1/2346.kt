package baekjoon.tony.`0_data_structure1`

import java.util.*

fun main() {
    val N = readln().toInt()
    val papers = readln().split(" ").map { it.toInt() }
    val balloons = ArrayDeque((1..N).map {
        Balloon(it, papers[it - 1])
    })

    val answer = arrayListOf<Int>()
    while (true) {
        val balloon = balloons.removeFirst()
        answer.add(balloon.number)

        if (balloons.isEmpty()) {
            break
        }

        if (balloon.paper > 0) {
            balloons.rotate(-balloon.paper + 1)
        } else {
            balloons.rotate(-balloon.paper)
        }
    }
    println(answer.joinToString(" "))
}

data class Balloon(val number: Int, val paper: Int)

fun <T> ArrayDeque<T>.rotate(places: Int) {
    if (isEmpty() || places == 0) return
    val effectivePlaces = places % size
    if (effectivePlaces > 0) {
        addFirst(removeLast())
        rotate(effectivePlaces - 1)
    } else if (effectivePlaces < 0) {
        addLast(removeFirst())
        rotate(effectivePlaces + 1)
    }
}

