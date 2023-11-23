package programmers.kotlin

import kotlin.math.abs

class Programmers12985 {
    fun solution(n: Int, a: Int, b: Int): Int {
        var orderA = (a + 1) / 2
        var orderB = (b + 1) / 2

        var answer = 1

        while (abs(orderA - orderB) > 0) {
            orderA = (orderA + 1) / 2
            orderB = (orderB + 1) / 2
            answer ++
        }

        return answer
    }
}