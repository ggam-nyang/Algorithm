package baekjoon

import java.util.Scanner
import kotlin.math.min

fun main() = with(Scanner(System.`in`)) {
    val (N, M) = nextLine().split(' ').map(String::toInt)
    val guitarBrand = arrayListOf<IntArray>()

    (1 .. M).forEach { _ ->
        nextLine().split(' ').map(String::toInt).let { guitarBrand.add(it.toIntArray()) }
    }

    val minSet = N / 6
    val minRemain = N % 6

    val packagePrice = guitarBrand.minBy { it[0] }[0]
    val remainPrice = guitarBrand.minBy { it[1] }[1]

    val minPrice =
        if (minSet > 0) min(packagePrice * minSet + remainPrice * minRemain, packagePrice * (minSet + 1))
        else min(packagePrice, remainPrice * minRemain)

    println(min(minPrice, remainPrice * N))
}