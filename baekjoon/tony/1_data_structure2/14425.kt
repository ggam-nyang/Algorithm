package baekjoon.tony.`1_data_structure2`

fun main() {
    val (N, M) = readln().split(" ").map(String::toInt)

    val stringMap = HashSet<String>(N)
    for (i in 1..N) {
        stringMap.add(readln())
    }

    var answer = 0
    for (i in 1..M) {
        if (stringMap.contains(readln())) answer++
    }

    println(answer)
}