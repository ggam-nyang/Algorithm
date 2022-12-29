package programmers

import kotlin.math.sqrt

// 138475
class Solution {
    private val divisorsMap = hashMapOf<Int, Int>()
    private val startToDivisorsMap = hashMapOf<Int, Pair<Int, Int>>()

    fun solution(e: Int, starts: IntArray): IntArray {
        (1 .. e).forEach { divisorsMap[it] = getDivisors(it) }

        startToDivisorsMap[e] = Pair(e, divisorsMap[e]!!)
        (e - 1 downTo  1).forEach { num ->
            val (maxStart, maxDivisors) = startToDivisorsMap[num + 1]!!
            if (divisorsMap[num]!! >= maxDivisors)
                startToDivisorsMap[num] = Pair(num, divisorsMap[num]!!)
            else
                startToDivisorsMap[num] = Pair(maxStart, maxDivisors)
        }

        return starts.map { startToDivisorsMap[it]!!.first }.toIntArray()
    }

    private fun getDivisors(someNum: Int): Int {
        if (divisorsMap.containsKey(someNum)) {
            return divisorsMap[someNum]!!
        }

        val squareRoot = sqrt(someNum.toDouble()).toInt()

        var divisors: Int = 0
        for (i in 1..squareRoot) {
            if (someNum % i == 0) {
                divisors++
            }
        }
        divisors = if (squareRoot * squareRoot == someNum) divisors * 2 - 1 else divisors * 2
        divisorsMap[someNum] = divisors

        return divisors
    }

    private fun getDivisors2(someNum: Int): Int {
        val squareRoot = sqrt(someNum.toDouble()).toInt()

        var i = 2
        var num = someNum

        while (num > 1) {
            if (num % i == 0)
        }
        for (i in 1..squareRoot) {
            if (someNum % i == 0) {
                divisors++
            }
        }
        divisors = if (squareRoot * squareRoot == someNum) divisors * 2 - 1 else divisors * 2
        divisorsMap[someNum] = divisors

        return divisors
    }
}