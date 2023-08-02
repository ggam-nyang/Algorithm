package baekjoon.tony.`0_data_structure1`

import java.util.LinkedList

fun main() {
    val (N, K) = readln().split(" ").map(String::toInt)

    val linkedList = LinkedList((1..N).toList())
    val answer = mutableListOf<Int>()

    var currIndex = K - 1
    while (linkedList.isNotEmpty()) {
        currIndex %= linkedList.size
        answer.add(linkedList.removeAt(currIndex))
        currIndex += K - 1
    }

    println("<${answer.joinToString()}>")
}
