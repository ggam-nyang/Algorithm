package baekjoon.smtc

import java.util.Scanner
import kotlin.math.abs
import kotlin.math.max

fun main() = with(Scanner(System.`in`)) {
    val statueN = nextLine().toInt()
    val statueList = nextLine().split(' ').map(String::toInt)

    val sortedSumList = statueList.map {
        if (it == 2) -1
        else it
    }
        .runningReduce { acc, i ->
        if (i == 1) acc + 1
        else acc - 1
    }.sorted()

    val maxInSumList = max(abs(sortedSumList.last()), abs(sortedSumList.first()))
    println(max(sortedSumList.last() - sortedSumList.first(), maxInSumList))
}