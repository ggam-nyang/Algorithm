package baekjoon

import java.util.Scanner

fun main() = with(Scanner(System.`in`)) {
    val (M, N) = nextLine().split(' ').map { it.toInt() }
    val univList = arrayListOf<List<Int>>()
    repeat((1..M).count())
    { univList.add(nextLine().split(' ').map { it.toInt() }) }

    val convertedUnivList = univList.map { convertToComparedList(it) }
    val convertedUnivSet =
        convertedUnivList
        .toSet()

    val answer = convertedUnivSet.sumOf { it ->
        val cnt = convertedUnivList.count { iit -> it.equal(iit) }
        cnt * (cnt - 1) / 2
    }

    println(answer)
}

fun convertToComparedList(list: List<Int>): List<Int> {
    val sortedSet = list.toSortedSet()
    return list.map { sortedSet.indexOf(it) }
}

fun List<Int>.equal(list: List<Int>): Boolean {
    if (this.size != list.size) return false

    for (i in 1 until this.size) {
        if (this[i] != list[i]) return false
    }

    return true
}