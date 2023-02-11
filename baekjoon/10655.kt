package baekjoon

import java.util.*
import kotlin.math.abs

fun main() = with(Scanner(System.`in`)) {
    val N = nextLine().toInt()
    val checkPoints = arrayListOf<Pt>()

    repeat((0 until N).count()) {
        val (x, y) = nextLine().split(" ").map(String::toInt)
        checkPoints.add(Pt(x, y))
    }

    var distSum = 0
    val dist = (1 until N - 1).map { i ->
        val first = abs(checkPoints[i].x - checkPoints[i - 1].x) + abs(checkPoints[i].y - checkPoints[i - 1].y)
        val second = abs(checkPoints[i + 1].x - checkPoints[i].x) + abs(checkPoints[i + 1].y - checkPoints[i].y)
        val third = abs(checkPoints[i + 1].x - checkPoints[i - 1].x) + abs(checkPoints[i + 1].y - checkPoints[i - 1].y)
        distSum += first

        first + second - third
    }
    distSum += abs(checkPoints[N - 2].x - checkPoints[N - 1].x) + abs(checkPoints[N - 2].y - checkPoints[N - 1].y)

    println(distSum - dist.max())
}

data class Pt(
    val x: Int,
    val y: Int
)