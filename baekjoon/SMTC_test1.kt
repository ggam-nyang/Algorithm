package baekjoon

import java.util.Scanner

fun main() = with(Scanner(System.`in`)) {
    val n = nextInt()

    println((1..n).sumOf { it.toLong() * (n / it) })
}
